package metrics;

import model.PaprikaApp;

/**
 * Created by Sarra on 09/12/2016.
 */
public class NumberOfStructs extends UnaryMetric<Integer> {

private NumberOfStructs(PaprikaApp paprikaApp, int value) {
        this.value = value;
        this.entity = paprikaApp;
        this.name = "number_of_structs";
        }

public static NumberOfStructs createNumberOfStructs(PaprikaApp paprikaApp, int value) {
    NumberOfStructs numberOfStructs = new NumberOfStructs(paprikaApp, value);
    numberOfStructs.updateEntity();
        return numberOfStructs;
        }

}