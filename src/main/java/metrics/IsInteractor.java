package metrics;

import model.PaprikaClass;

/**
 * Created by Sarra on 22/05/2016.
 */
public class IsInteractor extends UnaryMetric<Boolean>{

    private IsInteractor(PaprikaClass entity) {
        this.value = entity.isInteractor();
        this.entity = entity;
        this.name = "is_interactor";
    }

    public static IsInteractor createIsInteractor(PaprikaClass entity) {
        IsInteractor isInteractor= new IsInteractor(entity);
        isInteractor.updateEntity();
        return isInteractor;
    }
}