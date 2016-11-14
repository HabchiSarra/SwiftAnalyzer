package analyzer;

import model.*;
import parser.SwiftBaseListener;

import java.util.Stack;

/**
 * Created by Sarra on 23/09/2016.
 */
public class GraphGenerator extends SwiftBaseListener {

    PaprikaApp app;
    private Stack<PaprikaClass> classStack;
    private Stack<PaprikaMethod> methodStack;

    public GraphGenerator(PaprikaApp app) {
        this.app = app;
        classStack=new Stack<>();
        methodStack=new Stack<>();
    }

    public void buildClassDiagram(){
        for(PaprikaClass paprikaClass: this.app.getPaprikaClasses()){
            if((paprikaClass instanceof PaprikaBasicClass  )&& ((PaprikaBasicClass) paprikaClass ).getType()
                    == PaprikaClassTypes.CLASS){
                handleClassInheritance((PaprikaBasicClass) paprikaClass );
            }else{//Enums, interfaces, structs or extensions
                for(String name: paprikaClass.getInterfacesNames()){
                    PaprikaClass implementedInterface= getClass(name);
                    if(implementedInterface!=null){
                        paprikaClass.implement(implementedInterface);
                        //TODO for interfaces it's actually an "Inheritance" relationship
                    }else{
                        //TODO create an external class or no? if no: the NOI will be wrong
                    }
                }

            }
            //link extensions
            if(paprikaClass instanceof PaprikaExtension){
                for(PaprikaClass classe: this.app.getPaprikaClasses()){
                    if(classe instanceof PaprikaBasicClass && classe.getName().equals(paprikaClass.getName())){
                        ((PaprikaExtension) paprikaClass).setExtendedClass((PaprikaBasicClass) classe);
                    }
                }
            }

        }
    }
    PaprikaClass getClass(PaprikaClassTypes type, String name){//returns null if unfound
        for(PaprikaClass paprikaClass: this.app.getPaprikaClasses()){
            if(((PaprikaBasicClass) paprikaClass ).getType()== type && paprikaClass.getName().equals(name)){
                return paprikaClass;
            }
        }
        return null;
    }

    PaprikaClass getClass(String name){//returns null if unfound
        for(PaprikaClass paprikaClass: this.app.getPaprikaClasses()){
            if( paprikaClass.getName().equals(name)){
                return paprikaClass;
            }
        }
        return null;
    }

    public void handleClassInheritance(PaprikaBasicClass paprikaClass){
        int i = 0;
        for(String name: paprikaClass.getInterfacesNames()){
            PaprikaClass motherClass= getClass(name);
            if(motherClass!=null){
                if(i==0 && motherClass instanceof PaprikaBasicClass && ((PaprikaBasicClass)motherClass).
                        getType()!= PaprikaClassTypes.INTERFACE)
                {
                    //it's an inheritance
                    paprikaClass.setParent(motherClass);
                    paprikaClass.getInterfacesNames().remove(name);

                }else{
                    paprikaClass.implement(motherClass);
                }
            }else{
                //TODO create an external class or no? if no: the NOI will be wrong
            }
            i++;
        }
    }



}
