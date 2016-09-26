package analyzer;



import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.SwiftParser;

public class AstPrinter {

    public void print(RuleContext ctx) {
        explore(ctx, 0);
    }

    private void explore(RuleContext ctx, int indentation) {
        String ruleName = SwiftParser.ruleNames[ctx.getRuleIndex()];

        for (int i=0;i<indentation;i++) {
            System.out.print("  ");
        }
        System.out.println(ruleName);
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element, indentation + 1);
            }
        }
    }

}