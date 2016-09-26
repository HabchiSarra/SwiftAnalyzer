package model;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

/**
 * Created by Sarra on 07/04/2016.
 */
public class PaprikaStatement {
    private ParseTree context;
    private ArrayList<PaprikaStatementVariable> variables;
    private PaprikaStatement parentStatement;
    private ArrayList<PaprikaStatement> childrenStatements;

    private PaprikaStatement(ParseTree context,PaprikaStatement parentStatement) {
        this.context = context;
        this.variables =  new ArrayList<>(0);
        this.childrenStatements = new ArrayList<>(0);
        this.parentStatement = parentStatement;

    }

    public static PaprikaStatement createPaprikaStatement(ParseTree context, PaprikaStatement parentStatement, PaprikaMethod method){
        PaprikaStatement statement=null;
        if(parentStatement!= null){
            statement=new PaprikaStatement(context,parentStatement);
            parentStatement.addChildStatement(statement);
        }else if(method!=null){
            statement=new PaprikaStatement(context,parentStatement);
            method.setStatement(statement);
        }
        return statement;
    }

    public ParseTree getContext() {
        return context;
    }

    public void setContext(ParseTree context) {
        this.context = context;
    }

    public ArrayList<PaprikaStatementVariable> getVariables() {
        return variables;
    }

    public void addVariable(PaprikaStatementVariable variable) {
        this.variables.add(variable);
    }

    public PaprikaStatement getParentStatement() {
        return parentStatement;
    }

    public void setParentStatement(PaprikaStatement parentStatement) {
        this.parentStatement = parentStatement;
    }

    public ArrayList<PaprikaStatement> getChildrenStatements() {
        return childrenStatements;
    }

    public void addChildStatement(PaprikaStatement childStatement) {
        this.childrenStatements.add(childStatement);
    }
}
