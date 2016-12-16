package neo4j;

import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

/**
 * Created by Sarra on 22/05/2016.
 */
public class VIPERQuery extends Query {


    private VIPERQuery(QueryEngine queryEngine) {
            super(queryEngine);
        }

    public static VIPERQuery createVIPERQuery(QueryEngine queryEngine) {
        return new VIPERQuery(queryEngine);
    }

    @Override
    public void execute(boolean details) throws CypherException, IOException {
        try (Transaction ignored = graphDatabaseService.beginTx()) {
            String query = "MATCH (al:App) WHERE (al:App)-[:APP_OWNS_CLASS]->(:Class{is_interactor:true}) AND (al:App)-[:APP_OWNS_CLASS]->(:Class{is_router:true}) RETURN al.app_key as app_key";
            if(details){
                query += ",al.name as full_name";
            }else{
                query += ",count(al) as VIPER";
            }
            Result result = graphDatabaseService.execute(query);
            queryEngine.resultToCSV(result, "_VIPER.csv");
        }
    }
}


