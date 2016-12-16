package neo4j;

import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

/**
 * Created by Sarra on 13/10/2016.
 */
public class HEBTQuery extends FuzzyQuery{
    protected static double high_cc = 3.5;
    protected static double veryHigh_cc = 5;
    protected static double high_nol = 30.5;
    protected static double veryHigh_nol = 47;

    private HEBTQuery(QueryEngine queryEngine){
        super(queryEngine);
        this.fclFile="fcl/HEBT.fcl";

    }

    public static HEBTQuery createHEBTQuery(QueryEngine queryEngine) {

        return new HEBTQuery(queryEngine);
    }

    @Override
    public void execute(boolean details) throws CypherException, IOException {
        Result result;
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (m:Method{name:'applicationDidEnterBackground:'}) return m.app_key as app_key, m.cyclomatic_complexity as complexity, m.number_of_lines as number_of_lines";
            if(details){
                query += ",m.full_name as full_name";
            }else{
                query += ",count(m) as HEBT";
            }
            result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result,"_HEBT_NO_FUZZY.csv");
        }
    }

    @Override
    public void executeFuzzy(boolean details) throws CypherException, IOException {

    }


}
