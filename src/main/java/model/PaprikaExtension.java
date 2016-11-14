package model;

/**
 * Created by Sarra on 26/09/2016.
 */
public class PaprikaExtension extends PaprikaClass {

    private PaprikaClass extendedClass;
    private PaprikaExtension(String name, PaprikaApp app) {
        super(name,app);
        this.extendedClass =null;
    }

    public static PaprikaExtension createPaprikaExtension(String  name, PaprikaApp app) {
        PaprikaExtension paprikaExtension = new PaprikaExtension(name, app);
        app.addPaprikaExtension(paprikaExtension);
         return paprikaExtension;
    }

    public PaprikaClass getExtendedClass() {
        return extendedClass;
    }

    public void setExtendedClass(PaprikaBasicClass extendedClass) {
        this.extendedClass = extendedClass;
        extendedClass.addPaprikaExtension(this);
    }
}
