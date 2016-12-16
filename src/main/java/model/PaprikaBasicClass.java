package model;

import java.util.ArrayList;
import java.util.HashSet;


public class PaprikaBasicClass extends PaprikaClass{
    private PaprikaClass parent;
    //parent name to cover library case
    private String parentName;//TODO remove it?
    private int children;
    private PaprikaClassTypes type;
    private ArrayList<PaprikaExtension> extensions;
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    private PaprikaBasicClass(String name, PaprikaApp paprikaApp){
        super( name, paprikaApp);
        this.children = 0;
        this.parentName = null;
        numberOfLinesOfCode=0;
        extensions=new ArrayList<>();
           }
    public static PaprikaBasicClass createPaprikaBasicClass(String name, PaprikaApp paprikaApp) {
        PaprikaBasicClass paprikaClass = new PaprikaBasicClass(name, paprikaApp);
        paprikaApp.addPaprikaClass(paprikaClass);
        return paprikaClass;
    }
    public static PaprikaBasicClass createPaprikaBasicClass(String name,PaprikaClassTypes type, PaprikaApp paprikaApp) {
        PaprikaBasicClass paprikaClass = new PaprikaBasicClass(name, paprikaApp);
        paprikaApp.addPaprikaClass(paprikaClass);
        paprikaClass.type =type;
        return paprikaClass;
    }
    public PaprikaClass getParent() {
        return parent;
    }
    public void setParent(PaprikaClass parent) {
        this.parent = parent;
    }
    public void addChildren() { children += 1;}
    public int getChildren() { return children; }
    public PaprikaClassTypes getType() {
        return type;
    }

    public void setType(PaprikaClassTypes type) {
        this.type = type;
    }

    public ArrayList<PaprikaExtension> getExtensions() {
        return extensions;
    }

    public void addPaprikaExtension(PaprikaExtension paprikaExtension){
        this.extensions.add(paprikaExtension);
    }



}
