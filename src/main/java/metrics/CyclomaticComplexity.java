package metrics;

import model.Entity;
import model.PaprikaMethod;

/**
 * Created by Geoffrey Hecht on 22/05/14.
 */
public class CyclomaticComplexity extends UnaryMetric<Integer> {

    private CyclomaticComplexity(Entity paprikaMethod, int value) {
        this.value = value;
        this.entity = paprikaMethod;
        this.name = "cyclomatic_complexity";
        System.out.println("value::::::::::::  "+this.value+"  method:: "+paprikaMethod.getName());
    }

    public static CyclomaticComplexity createCyclomaticComplexity(Entity paprikaMethod, int value) {

        CyclomaticComplexity cyclomaticComplexity =  new CyclomaticComplexity(paprikaMethod, value);
        cyclomaticComplexity.updateEntity();
        return cyclomaticComplexity;
    }

}
