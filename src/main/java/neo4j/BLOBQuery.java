package neo4j;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Geoffrey Hecht on 14/08/15.
 */
public class BLOBQuery extends FuzzyQuery{
   // protected static double high_lcom = 25;
   // protected static double veryHigh_lcom = 40;
   /* protected static double high_noa = 8.5;
    protected static double veryHigh_noa = 13;
    protected static double high_nom = 14.5;
    protected static double veryHigh_nom = 22;
    protected static double veryLow_camc =2;
    protected static double low_camc = 3;*/
    protected static double high_noa = 15;
    protected static double veryHigh_noa = 24;
    protected static double high_nom = 18.5;
    protected static double veryHigh_nom = 29;
    protected static double veryLow_camc =0.1458333283662796;
    protected static double low_camc = 0.2;

    private BLOBQuery(QueryEngine queryEngine) {
        super(queryEngine);
        fclFile = "fcl/Blob.fcl";
    }

    public static BLOBQuery createBLOBQuery(QueryEngine queryEngine) {
        return new BLOBQuery(queryEngine);
    }

    public void execute(boolean details) throws CypherException, IOException {
        Result result;
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (cl:Class) WHERE cl.cohesion_among_methods_of_class <" + veryLow_camc + " AND cl.number_of_methods > " + veryHigh_nom + " AND cl.number_of_attributes > " + veryHigh_noa + " RETURN cl.app_key as app_key";
            if(details){
                query += ",cl.name as full_name";
            }else{
                query += ",count(cl) as BLOB";
            }
            result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result,"_BLOB_NO_FUZZY.csv");
        }
    }

    public void executeFuzzy(boolean details) throws CypherException, IOException {
            Result result;
            try (Transaction ignored = graphDatabaseService.beginTx()) {
                System.out.println("1st");
                String query = "MATCH (cl:Class) WHERE cl.cohesion_among_methods_of_class < " + veryLow_camc + " AND cl.number_of_methods > " + high_nom + " AND cl.number_of_attributes > " + high_noa + " RETURN cl.app_key as app_key,cl.cohesion_among_methods_of_class as cohesion_among_methods_of_class,cl.number_of_methods as number_of_methods, cl.number_of_attributes as number_of_attributes";
                if(details){
                    query += ",cl.name as full_name";
                }
                result = graphDatabaseService.execute(query);
                List<String> columns = new ArrayList<>(result.columns());
                columns.add("fuzzy_value");
                int noa,nom; double camc;
                List<Map> fuzzyResult = new ArrayList<>();
                File fcf = new File(fclFile);

                //We look if the file is in a directory otherwise we look inside the jar
                FIS fis;
                if(fcf.exists() && !fcf.isDirectory()){
                    fis = FIS.load(fclFile, false);
                }else{
                    fis = FIS.load(getClass().getResourceAsStream(fclFile),false);
                }
                FunctionBlock fb = fis.getFunctionBlock(null);
                while(result.hasNext()){
                    HashMap res = new HashMap(result.next());
                    System.out.println("pss1");
                    noa = (int) res.get("number_of_attributes");
                    System.out.println("pss");
                    Object o= res.get("cohesion_among_methods_of_class");
                    camc =(float) o;
                    nom = (int) res.get("number_of_methods");

                    if(camc <= veryLow_camc && noa >= veryHigh_noa && nom >= veryHigh_nom){
                        res.put("fuzzy_value", 1);
                    }else {
                        fb.setVariable("cohesion_among_methods_of_class",camc);
                        fb.setVariable("number_of_attributes",noa);
                        fb.setVariable("number_of_methods",nom);
                        fb.evaluate();
                        res.put("fuzzy_value", fb.getVariable("res").getValue());
                    }
                    fuzzyResult.add(res);
                    }
                    queryEngine.resultToCSV(fuzzyResult,columns,"_BLOB.csv");
            }
    }


}
