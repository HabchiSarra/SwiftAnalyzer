package metrics;

import model.PaprikaMethod;

/**
 * Created by Sarra on 09/12/2016.
 */
public class IsDeInit extends UnaryMetric<Boolean> {

    private IsDeInit(PaprikaMethod entity) {
        this.value = true;
        this.entity = entity;
        this.name = "is_deinit";
    }

    public static IsDeInit createIsDeInit(PaprikaMethod entity) {
        IsDeInit isDeInit = new IsDeInit(entity);
        isDeInit.updateEntity();
        return isDeInit;
    }
}
