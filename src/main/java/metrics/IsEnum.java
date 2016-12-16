package metrics;

import model.PaprikaBasicClass;
import model.PaprikaClass;
import model.PaprikaClassTypes;

/**
 * Created by Sarra on 08/12/2016.
 */
public class IsEnum  extends UnaryMetric<Boolean> {

    private IsEnum(PaprikaClass entity) {
        this.value =true;
        this.entity = entity;
        this.name = "is_enum";
    }

    public static IsEnum createIsEnum(PaprikaClass entity) {
        IsEnum isEnum = new IsEnum(entity);
        isEnum.updateEntity();
        return isEnum;
    }
}