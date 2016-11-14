package analyzer;

import model.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.SwiftLexer;
import parser.SwiftParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Created by Sarra on 08/06/2016.
 */
public class Main {

    public static void main(String[] args)
    {
        //The file path is hard-coded to avoid reading from System.in which is quite complicated with gradle
        File f = new File("C:\\Users\\Sarra\\Desktop\\Electric Objects\\Show.swift");
        String fileContent;
        SwiftLexer lexer;
        CommonTokenStream tokens;
        SwiftParser parser;
        ParseTree tree;
        AstPrinter astPrinter=new AstPrinter();
        ParseTreeWalker walker;
        PaprikaApp app =PaprikaApp.createPaprikaApp("AppTest","catTest","keyTest");
        ModelGenerator modelGenerator =new ModelGenerator(app);
      try {
          fileContent= readFile(f, Charset.forName("UTF-8"));
          lexer = new SwiftLexer(new ANTLRInputStream(fileContent));
          tokens = new CommonTokenStream(lexer);
          parser = new SwiftParser(tokens);
          tree = parser.topLevel();
        //  walker = new ParseTreeWalker();
         //walker.walk(modelGenerator, tree);
          astPrinter.print((RuleContext)tree);

        }catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("The cause:"+ ioe.getCause());
        }

    }

    private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public void showModel(PaprikaApp app){
        for(PaprikaClass paprikaClass: app.getPaprikaClasses()){

            if(paprikaClass instanceof PaprikaBasicClass){
                System.out.println(((PaprikaBasicClass)paprikaClass).getType().toString());
                System.out.print(paprikaClass.getName());
                if(((PaprikaBasicClass)paprikaClass).getParent()!=null){
                    System.out.println("I inherit from :"+((PaprikaBasicClass)paprikaClass).getParent().getName());
                }



            }else{//it's an extension
                System.out.println("EXTENSION");
                System.out.print(paprikaClass.getName());
                if(((PaprikaExtension) paprikaClass).getExtendedClass()!= null){
                    System.out.println("I extend "+((PaprikaExtension) paprikaClass).getExtendedClass().getName());
                }
            }

            if(!paprikaClass.getInterfaces().isEmpty()){
                System.out.print("I implement:");
                for (PaprikaClass protocol: paprikaClass.getInterfaces()){
                    System.out.print(" "+protocol.getName()+" ;");
                }
                System.out.println(" ");
            }
            if(!paprikaClass.getNestedClasses().isEmpty()){
                System.out.print("I nest:");
                for (PaprikaClass nestedClass: paprikaClass.getNestedClasses()){
                    System.out.print(" "+nestedClass.getName()+" ;");
                }
                System.out.println(" ");
            }

            showMethods(paprikaClass);

            System.out.println("____________________________________________________________________________________");
        }
    }

    public void showMethods(PaprikaClass paprikaClass){
        System.out.println("--My Methods are: ");
        for(PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
            System.out.println("  +"+paprikaMethod.getName());
            System.out.print("   My arguments:");
            for(PaprikaArgument paprikaArgument:paprikaMethod.getArguments()){
                System.out.print(" "+paprikaArgument.getName()+" - "+paprikaArgument.getArgumentName());
            }
            System.out.println(" ");
            if(!paprikaMethod.getNestedEntities().isEmpty()){
                System.out.print("   I nest:");
                for (Entity entity: paprikaMethod.getNestedEntities()){
                    if(entity instanceof PaprikaClass){
                        System.out.print(" class: ");
                    }else{
                        System.out.println(" method: ");
                    }
                    System.out.print(entity.getName()+" ;");
                }
                System.out.println(" ");
            }
        }
    }
}
