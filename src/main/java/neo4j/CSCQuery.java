package neo4j;

import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

/**
 * Created by Sarra on 24/05/2016.
 */
public class CSCQuery extends Query {


    private CSCQuery(QueryEngine queryEngine) {
        super(queryEngine);
    }

    public static CSCQuery createCSCQuery(QueryEngine queryEngine) {
        return new CSCQuery(queryEngine);
    }

    @Override
    public void execute(boolean details) throws CypherException, IOException {
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (cl:Class) WHERE (cl:Class)-[:CLASS_OWNS_METHOD]->(:Method)-[:CALLS]->(:ExternalMethod{name:'sendSynchronousRequest:returningResponse:error:'}) RETURN cl.app_key as app_key";
            if(details){
                query += ",cl.name as full_name";
            }else{
                query += ",count(cl) as CSC";
            }
            Result result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result, "_CSC.csv");
        }
    }
}