package model;



import java.util.ArrayList;
import java.util.Observer;


/**
 * Created by Sarra on 08/04/2016.
 */
public class PaprikaMessage extends Entity implements Observer{
    private PaprikaMethod callingMethod;
    private Entity calledMethod;//PaprikaMethod or a PaprikaExternalMethod
    //private Entity receiverEntity; // The entity which received the call
    private ArrayList<Observer> observers;

    private PaprikaMessage(Entity calledMethod,Entity receiverEntity, PaprikaMethod callingMethod) {
        this.name = "[ "+receiverEntity+"  "+calledMethod.getName() +" ]";
        this.calledMethod = calledMethod;
        this.callingMethod = callingMethod;
        //this.receiverEntity = receiverEntity;
        receiverEntity.addObserver(this);
        this.observers = new ArrayList<>(0);
    }

    public static PaprikaMessage createPaprikaMessage(Entity calledMethod, Entity reciverEntity, PaprikaMethod callingMethod){
        PaprikaMessage paprikaMessage = new PaprikaMessage(calledMethod,reciverEntity, callingMethod);
        callingMethod.addPaprikaMessage(paprikaMessage);
        return paprikaMessage;
    }

    public Entity getCalledMethod() {
        return calledMethod;
    }

    public void setCalledMethod(Entity calledMethod) {
        this.calledMethod = calledMethod;
    }



    public PaprikaMethod getCallingMethod() {
        return callingMethod;
    }

    public void setCallingMethod(PaprikaMethod callingMethod) {
        this.callingMethod = callingMethod;
    }

   /* public Entity getReciverEntity() {
        return receiverEntity;
    }

    public void setReciverEntity(Entity reciverEntity) {
        this.receiverEntity = reciverEntity;
        this.receiverEntity.addObserver(this);
    }*/



    //Observer
    @Override
    public void update(java.util.Observable o, Object arg) {
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
