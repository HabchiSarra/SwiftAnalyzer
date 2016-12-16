package model;

import java.util.ArrayList;

/**
 * Created by Sarra on 12/04/2016.
 */
public class PaprikaFunction extends Entity {
    private PaprikaApp paprikaApp;
    private String returnType;
    private ArrayList<Entity> nestedEntities;
    private int numberOfLines =0;
    private int complexity;

    private PaprikaFunction(String name , String returnType, PaprikaApp paprikaApp) {
        this.name = name;
        this.paprikaApp = paprikaApp;
        this.returnType = returnType;
        nestedEntities=new ArrayList<>();
        this.complexity=1;
    }

    public static PaprikaFunction createPaprikaFunction(String name , String returnType, PaprikaApp paprikaApp){
        PaprikaFunction function = new PaprikaFunction(name,returnType,paprikaApp);
        paprikaApp.addPaprikaFunction(function);
        return function;
    }
    public PaprikaApp getPaprikaApp() {
        return paprikaApp;
    }

    public void setPaprikaApp(PaprikaApp paprikaApp) {
        this.paprikaApp = paprikaApp;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Entity> getNestedEntities() {
        return nestedEntities;
    }

    public void addNestedEntity(Entity nestedEntity) {
        this.nestedEntities.add(nestedEntity);
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public int getCyclomaticComplexity() {
        return complexity;
    }
    public void addComplexity(int cyclomaticComplexity){
        this.complexity =+ cyclomaticComplexity;
    }

}
