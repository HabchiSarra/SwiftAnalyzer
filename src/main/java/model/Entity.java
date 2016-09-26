package model;

/*import paprika.metrics.Metric;
import paprika.metrics.UnaryMetric;*/

import metrics.Metric;
import metrics.UnaryMetric;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Geoffrey Hecht on 20/05/14.
 */
public abstract class Entity extends Observable {
    protected String name;
    private ArrayList<Observer> observers = new ArrayList<>(0);
    protected List<Metric> metrics = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public void addMetric(UnaryMetric unaryMetric){
        this.metrics.add(unaryMetric);
    }

    @Override
    public String toString() {
        return name;
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

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
}
