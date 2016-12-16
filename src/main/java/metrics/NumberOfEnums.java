package metrics;

import model.PaprikaApp;

/**
 * Created by Sarra on 09/12/2016.
 */
public class NumberOfEnums extends UnaryMetric<Integer> {

    private NumberOfEnums(PaprikaApp paprikaApp, int value) {
        this.value = value;
        this.entity = paprikaApp;
        this.name = "number_of_enums";
    }

    public static NumberOfEnums createNumberOfEnums(PaprikaApp paprikaApp, int value) {
        NumberOfEnums numberOfEnums = new NumberOfEnums(paprikaApp, value);
        numberOfEnums.updateEntity();
        return numberOfEnums;
    }

}