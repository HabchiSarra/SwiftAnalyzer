package model;

/**
 * Created by Sarra on 07/04/2016.
 */
public class PaprikaStatementVariable extends Entity {

    private String type;
    private PaprikaStatement paprikaStatement;
    private PaprikaStatementVariable(String name, String type, PaprikaStatement paprikaStatement) {
        this.type = type;
        this.name = name;
        this.paprikaStatement = paprikaStatement;

    }

    public static PaprikaStatementVariable createPaprikaStatementVariable(String name, String type, PaprikaStatement paprikaStatement) {
        PaprikaStatementVariable paprikaVariable= null;
        boolean exists = false;
        //Useless check
        for(PaprikaStatementVariable v : paprikaStatement.getVariables()){
            if((v.getName()).equals(name)){
                exists = true;
                paprikaVariable = v;
            }
        }
        if(exists == false){
            paprikaVariable= new PaprikaStatementVariable(name, type, paprikaStatement);
            paprikaStatement.addVariable(paprikaVariable);
        }

        return paprikaVariable;
    }

    public String getType() {
        return type;
    }
}
