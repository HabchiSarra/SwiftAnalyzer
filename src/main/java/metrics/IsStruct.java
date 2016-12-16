package metrics;

import model.PaprikaBasicClass;
import model.PaprikaClass;
import model.PaprikaClassTypes;

/**
 * Created by Sarra on 08/12/2016.
 */
public class IsStruct  extends UnaryMetric<Boolean> {

    private IsStruct(PaprikaClass entity) {
        this.value =true;
        this.entity = entity;
        this.name = "is_struct";
    }

    public static IsStruct createIsStruct(PaprikaClass entity) {
        IsStruct isStruct = new IsStruct(entity);
        isStruct.updateEntity();
        return isStruct;
    }
}