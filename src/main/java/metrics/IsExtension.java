package metrics;

import model.PaprikaBasicClass;
import model.PaprikaClass;
import model.PaprikaClassTypes;
import model.PaprikaExtension;

/**
 * Created by Sarra on 08/12/2016.
 */
public class IsExtension extends UnaryMetric<Boolean> {

    private IsExtension(PaprikaClass entity) {
        this.value =true;
        this.entity = entity;
        this.name = "is_extension";
    }

    public static IsExtension createIsExtension(PaprikaClass entity) {
        IsExtension isExtension = new IsExtension(entity);
        isExtension.updateEntity();
        return isExtension;
    }
}