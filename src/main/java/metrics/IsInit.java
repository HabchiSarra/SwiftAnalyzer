package metrics;

/**
 * Created by Geoffrey Hecht on 06/08/14.
 */

import model.PaprikaMethod;

public class IsInit extends UnaryMetric<Boolean> {

    private IsInit(PaprikaMethod entity) {
        this.value = true;
        this.entity = entity;
        this.name = "is_init";
    }

    public static IsInit createIsInit(PaprikaMethod entity) {
        IsInit isInit = new IsInit(entity);
        isInit.updateEntity();
        return isInit;
    }
}
