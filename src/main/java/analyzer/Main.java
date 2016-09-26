package analyzer;

import model.PaprikaApp;
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
}
