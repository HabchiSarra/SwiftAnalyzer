package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sarra on 26/09/2016.
 */
public class PaprikaExtension extends Entity{
    private PaprikaApp app;
    private int complexity;
    private Set<PaprikaClass> coupled;
    private Set<PaprikaMethod> paprikaMethods;
    private Set<PaprikaVariable> paprikaVariables;
    private Set<PaprikaClass> interfaces;
    private ArrayList<String> interfacesNames;
    private PaprikaModifiers modifier ;
    private int numberOfLinesOfCode;
    private PaprikaClass extendedClass;

    public Set<PaprikaVariable> getPaprikaVariables() {
        return paprikaVariables;
    }

    public Set<PaprikaMethod> getPaprikaMethods() {
        return paprikaMethods;
    }



    private PaprikaExtension(String name, PaprikaApp app) {
        this.app=app;
        this.extendedClass=null;
        this.setName(name);
        this.complexity = 0;
        this.paprikaMethods  = new HashSet<>(0);
        this.paprikaVariables = new HashSet<>(0);
        this.coupled = new HashSet<>();
        this.interfaces = new HashSet<>();
        this.interfacesNames = new ArrayList<>(0);
        this.modifier = PaprikaModifiers.PUBLIC; // The default visibility is Public
        numberOfLinesOfCode=0;
        //TODO add the private class case
    }

    public static PaprikaExtension createPaprikaExtension(String  name, PaprikaApp app) {
        PaprikaExtension paprikaExtension = new PaprikaExtension(name, app);
        app.addPaprikaExtension(paprikaExtension);
         return paprikaExtension;
    }



    public Set<PaprikaClass> getInterfaces(){ return interfaces;}


    public void addPaprikaMethod(PaprikaMethod paprikaMethod){
        paprikaMethods.add(paprikaMethod);
    }


    public void addComplexity(int value){
        complexity += value;
    }



    public int getComplexity() {
        return complexity;
    }



    public void coupledTo(PaprikaClass paprikaClass){
        if(paprikaClass!= this.extendedClass)
        {
            coupled.add(paprikaClass);
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

    public PaprikaClass getExtendedClass() {
        return extendedClass;
    }

    public void setExtendedClass(PaprikaClass extendedClass) {
        this.extendedClass = extendedClass;
        extendedClass.addPaprikaExtension(this);
    }
}
