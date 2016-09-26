package metrics;

import model.PaprikaClass;

/**
 * Created by Sarra on 04/05/2016.
 */
public class IsAppDelegate extends UnaryMetric<Boolean>{

    private IsAppDelegate(PaprikaClass entity) {
        this.value = entity.isViewController();
        this.entity = entity;
        this.name = "is_app_delegate";
    }

    public static IsAppDelegate createIsAppDelegate(PaprikaClass entity) {
        IsAppDelegate isAppDelegate= new IsAppDelegate(entity);
        isAppDelegate.updateEntity();
        return isAppDelegate;
    }
}
