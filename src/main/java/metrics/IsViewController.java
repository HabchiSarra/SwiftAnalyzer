package metrics;

import model.PaprikaClass;

/**
 * Created by Sarra on 04/05/2016.
 */
public class IsViewController extends UnaryMetric<Boolean>{

    private IsViewController(PaprikaClass entity) {
        this.value = entity.isViewController();
        this.entity = entity;
        this.name = "is_view_controller";
    }

    public static IsViewController createIsViewController(PaprikaClass entity) {
        IsViewController isViewController= new IsViewController(entity);
        isViewController.updateEntity();
        return isViewController;
    }
}
