package metrics;

import model.PaprikaClass;

/**
 * Created by Sarra on 24/05/2016.
 */
public class IsPresenter extends UnaryMetric<Boolean>{

    private IsPresenter(PaprikaClass entity) {
        this.value = entity.isInteractor();
        this.entity = entity;
        this.name = "is_presenter";
    }

    public static IsPresenter createIsPresenter(PaprikaClass entity) {
        IsPresenter isPresenter= new IsPresenter(entity);
        isPresenter.updateEntity();
        return isPresenter;
    }
}