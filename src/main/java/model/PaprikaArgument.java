package model;

public class PaprikaArgument extends Entity{
    private PaprikaMethod paprikaMethod;
    private int position;
    private String argumentName;

    private PaprikaArgument(String name, int position,String argumentName, PaprikaMethod paprikaMethod) {
        this.paprikaMethod = paprikaMethod;
        this.name = name;
        this.position = position;
        this.argumentName = argumentName;
    }

    public static PaprikaArgument createPaprikaArgument(String name, int position, String argumentName, PaprikaMethod paprikaMethod){
        PaprikaArgument paprikaArgument = new PaprikaArgument(name,position,argumentName,paprikaMethod);
        paprikaMethod.addArgument(paprikaArgument);
        return paprikaArgument;
    }

    public int getPosition() {
        return position;
    }

    public String getArgumentName() {
        return argumentName;
    }

    public void setArgumentName(String argumentName) {
        this.argumentName = argumentName;
    }
}
