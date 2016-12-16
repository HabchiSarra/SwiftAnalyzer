package neo4j;

import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

/**
 * Created by Sarra on 22/05/2016.
 */
public class ILMWQuery extends Query {


    private ILMWQuery(QueryEngine queryEngine) {
        super(queryEngine);
    }

    public static ILMWQuery createILMWQuery(QueryEngine queryEngine) {
        return new ILMWQuery(queryEngine);
    }

    @Override
    public void execute(boolean details) throws CypherException, IOException {
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (cl:Class) WHERE HAS(cl.is_view_controller) AND NOT (cl:Class)-[:CLASS_OWNS_METHOD]->(:Method{name:'didReceiveMemoryWarning'}) RETURN cl.app_key as app_key";
            if(details){
                query += ",cl.name as full_name";
            }else{
                query += ",count(cl) as ILMW";
            }
            Result result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result, "_ILMW.csv");
        }
    }
}
