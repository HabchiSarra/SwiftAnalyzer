package analyzer;

import model.PaprikaApp;
import model.PaprikaClass;
import model.PaprikaClassTypes;
import model.PaprikaMethod;
import org.antlr.v4.runtime.misc.NotNull;
import parser.SwiftBaseListener;
import parser.SwiftParser;

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
            if(paprikaClass.getType()== PaprikaClassTypes.CLASS){
                handleClassInheritance(paprikaClass);
            }else{//Enums interfaces or structs
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
        }
    }
    PaprikaClass getClass(PaprikaClassTypes type, String name){//returns null if unfound
        for(PaprikaClass paprikaClass: this.app.getPaprikaClasses()){
            if(paprikaClass.getType() == type && paprikaClass.getName().equals(name)){
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

    public void handleClassInheritance(PaprikaClass paprikaClass){
        //TODO how to distinguish the inheritance from the implementation
        for(String name: paprikaClass.getInterfacesNames()){
            PaprikaClass implementedInterface= getClass(name);
            if(implementedInterface!=null){
                paprikaClass.implement(implementedInterface);
            }else{
                //TODO create an external class or no? if no: the NOI will be wrong
            }
        }
    }



}
