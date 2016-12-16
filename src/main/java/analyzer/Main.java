package analyzer;

import metrics.MetricsCalculator;
import model.*;
import neo4j.ModelToGraph;
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
import java.util.HashMap;

/**
 * Created by Sarra on 08/06/2016.
 */
public class Main {

    static HashMap<String,String> filesContents;
    public static String fileName =null ;
    static HashMap<String,String> headersContents;

    public Main(){
        filesContents = new HashMap<>();
        headersContents = new HashMap<>();
    }

    public static void main(String[] args)
    {
        filesContents = new HashMap<>();
        headersContents = new HashMap<>();
        //The file path is hard-coded to avoid reading from System.in which is quite complicated with gradle
        final File f = new File("C:\\Users\\Sarra\\Desktop\\Electric Objects");
        String fileContent;
        SwiftLexer lexer;
        CommonTokenStream tokens;
        SwiftParser parser;
        ParseTree tree;
        AstPrinter astPrinter=new AstPrinter();
        ParseTreeWalker walker;
        PaprikaApp app =PaprikaApp.createPaprikaApp("AppTest","catTest","keyTest");
        try {
            listFilesForFolder(f);
        }catch (Exception e){
            System.out.println("Folder exploring problem");
            e.printStackTrace();
            System.exit(1);
        }

        ModelGenerator modelGenerator =new ModelGenerator(app);
        for(String  name: filesContents.keySet()) {
            fileName = name;
            fileContent = filesContents.get(name);

                //fileContent = readFile(f, Charset.forName("UTF-8"));
                lexer = new SwiftLexer(new ANTLRInputStream(fileContent));
                tokens = new CommonTokenStream(lexer);
                parser = new SwiftParser(tokens);
                tree = parser.topLevel();
                walker = new ParseTreeWalker();
                walker.walk(modelGenerator, tree);

                //astPrinter.print((RuleContext)tree);



            modelGenerator.reInit();
        }
        GraphGenerator graphGenerator=new GraphGenerator(modelGenerator.app);
        graphGenerator.buildClassDiagram();
        //showModel(graphGenerator.app);
        MetricsCalculator.calculateAppMetrics(modelGenerator.app);
        ModelToGraph modelToGraph = new ModelToGraph("BDD-Swift");
        modelToGraph.insertApp(modelGenerator.app);

    }

    private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public static void showModel(PaprikaApp app){
        System.out.println("App: "+ app.getName() +" categorie "+ app.getCategory()+" calls synchronous "+ app.isCallsSynchronous());
        for(PaprikaClass paprikaClass: app.getPaprikaClasses()){

            if(paprikaClass instanceof PaprikaBasicClass){
                System.out.println(((PaprikaBasicClass)paprikaClass).getType().toString());
                System.out.println(paprikaClass.getName());
                if(((PaprikaBasicClass)paprikaClass).getParent()!=null){
                    System.out.println(" I inherit from:"+((PaprikaBasicClass)paprikaClass).getParent().getName());
                }



            }else{//it's an extension
                System.out.println("EXTENSION");
                System.out.println(paprikaClass.getName());
                if(((PaprikaExtension) paprikaClass).getExtendedClass()!= null){
                    System.out.println(" I extend: "+((PaprikaExtension) paprikaClass).getExtendedClass().getName());
                }
            }

            if(!paprikaClass.getInterfaces().isEmpty()){
                System.out.println(" I implement:");
                for (PaprikaClass protocol: paprikaClass.getInterfaces()){
                    System.out.println(" "+protocol.getName()+" ;");
                }
                System.out.println(" ");
            }
            if(!paprikaClass.getNestedClasses().isEmpty()){
                System.out.println("I nest:");
                for (PaprikaClass nestedClass: paprikaClass.getNestedClasses()){
                    System.out.println(" "+nestedClass.getName()+" ;");
                }
                System.out.println(" ");
            }
            System.out.println("Complexity: "+paprikaClass.getComplexity());
            showMethods(paprikaClass);
            showAttributes(paprikaClass);
            System.out.println("____________________________________________________________________________________");
        }
    }

    public static void showMethods(PaprikaClass paprikaClass){
        System.out.println("Number of lines: "+ paprikaClass.getNumberOfLinesOfCode());
        System.out.println("--My Methods are: ");
        for(PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
            System.out.println("  +"+paprikaMethod.getName());
            System.out.println("Method number of lines: "+ paprikaMethod.getNumberOfLines());
            System.out.println("   My arguments:");
            for(PaprikaArgument paprikaArgument:paprikaMethod.getArguments()){
                System.out.println(" "+paprikaArgument.getName()+" - "+paprikaArgument.getArgumentName());
            }
            System.out.println(" ");
            if(!paprikaMethod.getNestedEntities().isEmpty()){
                System.out.println("   I nest:");
                for (Entity entity: paprikaMethod.getNestedEntities()){
                    if(entity instanceof PaprikaClass){
                        System.out.println(" class: ");
                    }else{
                        System.out.println(" method: ");
                    }
                    System.out.println(entity.getName()+" ;");
                }
                System.out.println(" ");
            }
        }
    }

    public static void showAttributes(PaprikaClass paprikaClass){
        System.out.println("===== My variables are: ");
        for(PaprikaVariable paprikaVariable: paprikaClass.getPaprikaVariables()){
            System.out.println("      "+ paprikaVariable.getName()+ " type: "+ paprikaVariable.getType());
        }
    }


    public static void listFilesForFolder(final File folder) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if(fileEntry.getName().endsWith(".blabla")){
                    // System.out.println(".h: "+fileEntry.getName());
                    headersContents.put(fileEntry.getName(),readFile(new File(fileEntry.getPath()), Charset.forName("UTF-8")) );
                }else if(fileEntry.getName().endsWith(".swift")){
                    //System.out.println(".m: "+fileEntry.getName());
                    filesContents.put(fileEntry.getName(),readFile(new File(fileEntry.getPath()), Charset.forName("UTF-8")) );
                }

            }
        }
    }
}
