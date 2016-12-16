package metrics;

import model.PaprikaApp;

/**
 * Created by Sarra on 09/12/2016.
 */
public class NumberOfExtensions extends UnaryMetric<Integer> {

    private NumberOfExtensions(PaprikaApp paprikaApp, int value) {
        this.value = value;
        this.entity = paprikaApp;
        this.name = "number_of_extensions";
    }

    public static NumberOfExtensions createNumberOfExtensions(PaprikaApp paprikaApp, int value) {
        NumberOfExtensions numberOfExtensions = new NumberOfExtensions(paprikaApp, value);
        numberOfExtensions.updateEntity();
        return numberOfExtensions;
    }

}