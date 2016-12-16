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
public class LMQuery extends FuzzyQuery{
    protected static double high = 30.5;
    protected static double veryHigh = 47;

    private LMQuery(QueryEngine queryEngine) {
        super(queryEngine);
        fclFile = "fcl/LongMethod.fcl";
    }

    public static LMQuery createLMQuery(QueryEngine queryEngine) {
        return new LMQuery(queryEngine);
    }

    public void execute(boolean details) throws CypherException, IOException {
        Result result;
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (m:Method) WHERE m.number_of_lines >" + veryHigh + " RETURN m.app_key as app_key";
            if(details){
                query += ",m.full_name as full_name";
            }else{
                query += ",count(m) as LM";
            }
            result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result,"_LM_NO_FUZZY.csv");
        }
    }

    public void executeFuzzy(boolean details) throws CypherException, IOException {
            Result result;
            try (Transaction ignored = graphDatabaseService.beginTx()) {
                String query =  "MATCH (m:Method) WHERE m.number_of_lines >" + high + " RETURN m.app_key as app_key, m.number_of_lines as number_of_lines";
                if(details){
                    query += ",m.full_name as full_name";
                }
                result = graphDatabaseService.execute(query);
                List<String> columns = new ArrayList<>(result.columns());
                columns.add("fuzzy_value");
                int cc;
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
                    cc = (int) res.get("number_of_lines");
                    if(cc >= veryHigh){
                        res.put("fuzzy_value", 1);
                    }else {
                        fb.setVariable("number_of_lines",cc);
                        fb.evaluate();
                        res.put("fuzzy_value", fb.getVariable("res").getValue());
                    }
                    fuzzyResult.add(res);
                    }
                    queryEngine.resultToCSV(fuzzyResult,columns,"_LM.csv");
            }
    }

}
