package metrics;

import model.PaprikaApp;
import model.PaprikaClass;

/**
 * Created by Sarra on 09/12/2016.
 */
public class IsCallingSynchronous   extends UnaryMetric<Boolean> {

    private IsCallingSynchronous(PaprikaApp entity) {
        this.value =true;
        this.entity = entity;
        this.name = "is_calling_synchronous";
    }

    public static IsCallingSynchronous createIsCallingSynchronous(PaprikaApp entity) {
        IsCallingSynchronous isCallingSynchronous = new IsCallingSynchronous(entity);
        isCallingSynchronous.updateEntity();
        return isCallingSynchronous;
    }
}