package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sarra on 03/10/2016.
 */
public class PaprikaClass extends Entity{
    private PaprikaApp paprikaApp;
    private int complexity;
    private Set<PaprikaClass> coupled;
    private Set<PaprikaMethod> paprikaMethods;
    private Set<PaprikaVariable> paprikaVariables;
    private Set<PaprikaClass> interfaces;
    private ArrayList<String> interfacesNames;
    private PaprikaModifiers modifier ;
    private boolean isAppDelegate;
    private boolean isViewController;
    private int numberOfLinesOfCode;
    private boolean isInteractor;
    private boolean isRouter;
    private boolean isPresenter;
    private ArrayList<PaprikaClass> nestedClasses;

    public Set<PaprikaVariable> getPaprikaVariables() {
        return paprikaVariables;
    }

    public Set<PaprikaMethod> getPaprikaMethods() {
        return paprikaMethods;
    }



    protected PaprikaClass(String name, PaprikaApp paprikaApp) {
        this.setName(name);
        this.paprikaApp = paprikaApp;
        this.complexity = 0;
        this.paprikaMethods  = new HashSet<>(0);
        this.paprikaVariables = new HashSet<>(0);
        this.coupled = new HashSet<>();
        this.interfaces = new HashSet<>();
        this.interfacesNames = new ArrayList<>(0);
        this.nestedClasses = new ArrayList<>();
        this.modifier = PaprikaModifiers.PUBLIC; // The default visibility is Public
        numberOfLinesOfCode=0;
        //check if it's a ViewController or an AppDelegate
        this.isViewController=false;
        this.isViewController=false;
        this.isInteractor=false;
        this.isRouter=false;
        this.isPresenter=false;
        String lowerCaseName = name.toLowerCase();
        if(lowerCaseName.contains("viewcontroller")){
            this.isViewController=true;
        }else if(lowerCaseName.contains("appdelegate")){
            this.isAppDelegate=true;
        }else if(lowerCaseName.contains("interactor")){
            this.isInteractor=true;
        }else if(lowerCaseName.contains("router")|| lowerCaseName.contains("wireframe")){
            this.isRouter =true;
        }else if(lowerCaseName.endsWith("presenter")){
            this.isPresenter=true;
        }
        //TODO add the private class case
    }





    public Set<PaprikaClass> getInterfaces(){ return interfaces;}



    public void addPaprikaMethod(PaprikaMethod paprikaMethod){
        paprikaMethods.add(paprikaMethod);
    }

    public PaprikaApp getPaprikaApp() {
        return paprikaApp;
    }

    public void setPaprikaApp(PaprikaApp paprikaApp) {
        this.paprikaApp = paprikaApp;
    }

    public void addComplexity(int value){
        complexity += value;
    }
    public int getComplexity() {
        return complexity;
    }
    public void coupledTo(PaprikaClass paprikaBasicClass){
        if(paprikaBasicClass!= this)
        {
            coupled.add(paprikaBasicClass);
        }
    }

    public void implement(PaprikaClass paprikaClass){ interfaces.add(paprikaClass);}

    public int getCouplingValue(){ return coupled.size();}

    public int computeLCOM(){
        Object methods[] = paprikaMethods.toArray();
        int methodCount = methods.length;
        int haveFieldInCommon = 0;
        int noFieldInCommon  = 0;
        for(int i=0; i< methodCount;i++){
            for(int j=i+1; j < methodCount; j++){
                if( ((PaprikaMethod) methods[i]).haveCommonFields((PaprikaMethod) methods[j])){
                    haveFieldInCommon++;
                }else{
                    noFieldInCommon++;
                }
            }
        }
        int LCOM =  noFieldInCommon - haveFieldInCommon;
        return LCOM > 0 ? LCOM : 0;
    }

    public float computeCAMC(){
        ArrayList<String> classParameters = new ArrayList<>(0);
        ArrayList<String> methodParameters;
        int classNumber = 0;
        for(PaprikaMethod paprikaMethod: this.getPaprikaMethods()){
            methodParameters=new ArrayList<>();
            for(PaprikaArgument argument: paprikaMethod.getArguments()){
                if(!methodParameters.contains(argument.getName())){
                    methodParameters.add(argument.getName());
                    if(!classParameters.contains(argument.getName()))
                    {
                        classParameters.add(argument.getName());
                    }
                }
            }
            classNumber = classNumber+ methodParameters.size();
        }
        float camc=1;
        if(classParameters.size()!=0){
            camc = ((float)classNumber)/((float)classParameters.size()*(float)this.getPaprikaMethods().size());
        }

        return camc;
    }

    public void addPaprikaVariable(PaprikaVariable paprikaVariable) {
        paprikaVariables.add(paprikaVariable);
    }

    public PaprikaVariable findVariable(String name){
        // First we are looking to the field declared by this class (any modifiers)
        for (PaprikaVariable paprikaVariable : paprikaVariables){
            if (paprikaVariable.getName().equals(name)) return paprikaVariable;
        }
        //otherwise we return null
        return null;
    }

    public ArrayList<String> getInterfacesNames() {
        return interfacesNames;
    }
    public void setInterfacesNames(ArrayList<String> list) {
        this.interfacesNames= list;
    }
    public void addInterfaceName(String name) {
        this.interfacesNames.add(name);
    }
    public PaprikaModifiers getModifier() {
        return modifier;
    }

    public void setModifier(PaprikaModifiers modifier) {
        this.modifier = modifier;
    }

    public int getNumberOfLinesOfCode() {
        return numberOfLinesOfCode;
    }

    public void setNumberOfLinesOfCode(int numberOfLinesOfCode) {
        this.numberOfLinesOfCode = numberOfLinesOfCode;
    }

    public boolean isAppDelegate() {
        return isAppDelegate;
    }

    public boolean isViewController() {
        return isViewController;
    }

    public boolean isInteractor() {
        return isInteractor;
    }

    public boolean isRouter() {
        return isRouter;
    }

    public boolean isPresenter() {
        return isPresenter;
    }

    public ArrayList<PaprikaClass> getNestedClasses() {
        return nestedClasses;
    }

    public void addNestedClass(PaprikaClass paprikaClass){
        this.nestedClasses.add(paprikaClass);
    }
}
