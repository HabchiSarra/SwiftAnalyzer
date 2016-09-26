package metrics;

import model.PaprikaClass;

/**
 * Created by Sarra on 22/05/2016.
 */
public class IsRouter extends UnaryMetric<Boolean>{

    private IsRouter(PaprikaClass entity) {
        this.value = entity.isRouter();
        this.entity = entity;
        this.name = "is_router";
    }

    public static IsRouter createIsRouter(PaprikaClass entity) {
        IsRouter isRouter= new IsRouter(entity);
        isRouter.updateEntity();
        return isRouter;
    }
}