package metrics;

import model.Entity;

/**
 * Created by Geoffrey Hecht on 22/05/14.
 */
public class NumberOfLines extends UnaryMetric<Integer> {

    private NumberOfLines(Entity paprikaMethod, int value) {
        this.value = value;
        this.entity = paprikaMethod;
        this.name = "number_of_lines";
    }

    public static NumberOfLines createNumberOfLines(Entity paprikaMethod, int value) {
        NumberOfLines numberOfInstructions = new NumberOfLines(paprikaMethod, value);
        numberOfInstructions.updateEntity();
        return numberOfInstructions;
    }

}
