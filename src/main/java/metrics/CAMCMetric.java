package metrics;

/**
 * Created by Sarra on 22/05/2016.
 */

import model.PaprikaClass;


public class CAMCMetric extends UnaryMetric<Integer> {

    private CAMCMetric(PaprikaClass paprikaClass) {
        this.value = paprikaClass.computeCAMC();
        this.entity = paprikaClass;
        this.name = "cohesion_among_methods_of_class";
    }

    public static CAMCMetric createCAMCMetric(PaprikaClass paprikaClass) {
        CAMCMetric camc = new CAMCMetric(paprikaClass);
        camc.updateEntity();
        return camc;
    }
}
