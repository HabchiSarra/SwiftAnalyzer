package model;

/**
 * Created by Sarra on 11/04/2016.
 */
public class PaprikaGlobalVariable extends Entity{
    PaprikaApp app;
    String type;



    private PaprikaGlobalVariable(String name, String type, PaprikaApp app) {
        this.type = type;
        this.name = name;
        this.app=app;

    }

    public static PaprikaGlobalVariable createPaprikaGlobalVariable(String name, String type,PaprikaApp app) {
        PaprikaGlobalVariable paprikaVariable= new PaprikaGlobalVariable(name, type, app);
        app.addPaprikaGlobalVariable(paprikaVariable);
        return paprikaVariable;
    }

    public PaprikaApp getApp() {
        return app;
    }

    public void setApp(PaprikaApp app) {
        this.app = app;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
