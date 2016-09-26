package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sarra on 08/04/2016.
 */
public class PaprikaExternalVariable extends Entity implements Observer{
    private String type;
    private PaprikaExternalClass paprikaExternalClass;
    private ArrayList<Observer> observers;

    private PaprikaExternalVariable(String name,String type, PaprikaExternalClass paprikaExternalClass) {
        this.name = name;
        this.type = type;
        this.paprikaExternalClass = paprikaExternalClass;
        observers = new ArrayList<>(0);
    }
    public static PaprikaExternalVariable createPaprikaExternalVariable(String name,String type, PaprikaExternalClass paprikaExternalClass){
        //Check if the class already contains the variable
        for(PaprikaExternalVariable externalVariable: paprikaExternalClass.getPaprikaExternalVariables()){
            if(externalVariable.getName()== name && externalVariable.getType() == type){
                return externalVariable;
            }
        }
        PaprikaExternalVariable paprikaExternalVariable = new PaprikaExternalVariable(name,type,paprikaExternalClass);
        paprikaExternalClass.addPaprikaExternalVariable(paprikaExternalVariable);
        paprikaExternalClass.addObserver(paprikaExternalVariable);
        return paprikaExternalVariable;
    }

    public static PaprikaExternalVariable createPaprikaExternalVariable(String name,String type, PaprikaExternalClass paprikaExternalClass, Entity receiver){
        //Check if the class already contains the variable
        for(PaprikaExternalVariable externalVariable: paprikaExternalClass.getPaprikaExternalVariables()){
            if(externalVariable.getName()== name && externalVariable.getType() == type){
                return externalVariable;
            }
        }
        PaprikaExternalVariable paprikaExternalVariable = new PaprikaExternalVariable(name,type,paprikaExternalClass);
        paprikaExternalClass.addPaprikaExternalVariable(paprikaExternalVariable);
        receiver.addObserver(paprikaExternalVariable);
        return paprikaExternalVariable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaprikaExternalClass getPaprikaExternalClass() {
        return paprikaExternalClass;
    }

    public void setPaprikaExternalClass(PaprikaExternalClass paprikaExternalClass) {
        this.paprikaExternalClass = paprikaExternalClass;
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO update
    }

    //Observable
    @Override
    public synchronized void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for(Observer o : this.observers){
            o.update(this,arg);
        }
    }
}
