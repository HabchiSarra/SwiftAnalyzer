package model;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaprikaMethod extends Entity{
    private PaprikaClass paprikaClass;
    private String returnType;
    private boolean isFunction;
    private boolean isStatic;
    private ParseTree ctx;
    private PaprikaModifiers modifier;
    private Set<PaprikaVariable> usedVariables;
    private Set<Entity> calledMethods;
    private List<PaprikaArgument> arguments;
    private PaprikaStatement statement;
    private ArrayList<PaprikaMessage> paprikaMessages;
    private int numberOfLines;
    private int cyclomaticComplexity;
    private ArrayList<Entity> nestedEntities;

    private PaprikaMethod(String name, String returnType, PaprikaClass paprikaClass, boolean isFunction, boolean isStatic) {
        this.setName(name);
        this.paprikaClass = paprikaClass;
        this.usedVariables = new HashSet<>(0);
        this.calledMethods = new HashSet<>(0);
        this.arguments = new ArrayList<>(0);
        nestedEntities= new ArrayList<>();
        this.returnType = returnType;
        this.isFunction = isFunction;
        this.isStatic = isStatic;
        ctx = null ;
        modifier = PaprikaModifiers.PUBLIC; // The default visibility of methods is public
        this.paprikaMessages = new ArrayList<>(0);
        numberOfLines= 0 ;
        cyclomaticComplexity=1;
    }

    public static PaprikaMethod createPaprikaMethod(String name, String returnType,  PaprikaClass paprikaClass, boolean isFunction, boolean isStatic) {
        for(PaprikaMethod method: paprikaClass.getPaprikaMethods()){
            if(method.getName() == name){
                return method;
            }
        }
        PaprikaMethod paprikaMethod = new PaprikaMethod(name,  returnType, paprikaClass, isFunction, isStatic);
        paprikaClass.addPaprikaMethod(paprikaMethod);
        return  paprikaMethod;
    }

    public PaprikaClass getPaprikaClass() {
        return paprikaClass;
    }

    public void setPaprikaClass(PaprikaClass paprikaClass) {
        this.paprikaClass = paprikaClass;
    }

    @Override
    public String toString() {
        return this.getName() + "#" + paprikaClass;
    }

    public void useVariable(PaprikaVariable paprikaVariable) {
        usedVariables.add(paprikaVariable);
    }

    public Set<PaprikaVariable> getUsedVariables(){
        return this.usedVariables;
    }

    public void callMethod(Entity paprikaMethod) {
        if(paprikaMethod instanceof PaprikaMethod){
            if(paprikaMethod==this){
                return;
            }
        }
        calledMethods.add(paprikaMethod);
    }

    public Set<Entity> getCalledMethods() { return this.calledMethods; }

    public boolean haveCommonFields(PaprikaMethod paprikaMethod){
        Set<PaprikaVariable> otherVariables = paprikaMethod.getUsedVariables();
        for(PaprikaVariable paprikaVariable : usedVariables){
            if(otherVariables.contains(paprikaVariable)) return true;
        }
        return false;
    }

    public void addArgument(PaprikaArgument paprikaArgument){
        this.arguments.add(paprikaArgument);
    }

    public List<PaprikaArgument> getArguments(){
        return arguments;
    }

    public Boolean getFunction() {
        return isFunction;
    }

    public void setFunction(Boolean function) {
        isFunction = function;
    }

    public Boolean getStatic() {
        return isStatic;
    }

    public void setStatic(Boolean aStatic) {
        isStatic = aStatic;
    }

    public ParseTree getCtx() {
        return ctx;
    }

    public void setCtx(ParseTree ctx) {
        this.ctx = ctx;
    }
    public String getReturnType() {
        return returnType;
    }

    public PaprikaStatement getStatement() {
        return statement;
    }

    public void setStatement(PaprikaStatement statement) {
        this.statement = statement;
    }

    public ArrayList<PaprikaMessage> getPaprikaMessages() {
        return paprikaMessages;
    }

    public void addPaprikaMessage(PaprikaMessage paprikaMessage) {
        this.paprikaMessages.add( paprikaMessage);
    }

    public PaprikaModifiers getModifier() {
        return modifier;
    }

    public void setModifier(PaprikaModifiers modifier) {
        this.modifier = modifier;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public int getCyclomaticComplexity() {
        return cyclomaticComplexity;
    }

    public void setCyclomaticComplexity(int cyclomaticComplexity) {
        this.cyclomaticComplexity = cyclomaticComplexity;
    }

    public ArrayList<Entity> getNestedEntities() {
        return nestedEntities;
    }

    public void addNestedEntity(Entity nestedEntity) {
        this.nestedEntities.add(nestedEntity);
    }
}
