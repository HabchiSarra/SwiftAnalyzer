package metrics;

/**
 * Created by Geoffrey Hecht on 06/08/14.
 */

import model.PaprikaBasicClass;
import model.PaprikaClass;
import model.PaprikaClassTypes;

public class IsInterface extends UnaryMetric<Boolean> {

    private IsInterface(PaprikaClass entity) {
        this.value =true;
        this.entity = entity;
        this.name = "is_interface";
    }

    public static IsInterface createIsInterface(PaprikaClass entity) {
        IsInterface isInterface = new IsInterface(entity);
        isInterface.updateEntity();
        return isInterface;
    }
}
