package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class PaprikaExternalClass extends Entity {
    private PaprikaApp paprikaApp;
    private String parentName;
    private Set<PaprikaExternalMethod> paprikaExternalMethods;
    private ArrayList<PaprikaExternalVariable> paprikaExternalVariables;



    private PaprikaExternalClass(String name, PaprikaApp paprikaApp) {
        this.setName(name);
        this.paprikaApp = paprikaApp;
        this.paprikaExternalMethods  = new HashSet<>();
        this.paprikaExternalVariables = new ArrayList<>();
    }

    public static PaprikaExternalClass createPaprikaExternalClass(String name, PaprikaApp paprikaApp) {
        //Check if the class exists already
        for(PaprikaExternalClass c : paprikaApp.getPaprikaExternalClasses()){
            if(c.getName().equals(name)){
                return c;
            }
        }
        PaprikaExternalClass paprikaClass = new PaprikaExternalClass(name, paprikaApp);
        paprikaApp.addPaprikaExternalClass(paprikaClass);
        return paprikaClass;
    }


    public void addPaprikaExternalMethod(PaprikaExternalMethod paprikaMethod){
        paprikaExternalMethods.add(paprikaMethod);
    }

    public PaprikaApp getPaprikaApp() {
        return paprikaApp;
    }

    public void setPaprikaApp(PaprikaApp paprikaApp) {
        this.paprikaApp = paprikaApp;
    }

    public ArrayList<PaprikaExternalVariable> getPaprikaExternalVariables() {
        return paprikaExternalVariables;
    }

    public void addPaprikaExternalVariable(PaprikaExternalVariable paprikaExternalVariable) {
        this.paprikaExternalVariables.add(paprikaExternalVariable);
    }
    public Set<PaprikaExternalMethod> getPaprikaExternalMethods() {
        return paprikaExternalMethods;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }



}
