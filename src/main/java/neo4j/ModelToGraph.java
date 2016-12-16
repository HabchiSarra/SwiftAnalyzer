package neo4j;

import metrics.Metric;
import model.*;
import org.neo4j.graphdb.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

/**
 * Created by Geoffrey Hecht on 05/06/14.
 */
public class ModelToGraph {
    private GraphDatabaseService graphDatabaseService;
    private DatabaseManager databaseManager;
    private static final Label appLabel = DynamicLabel.label("App");
    private static final Label classLabel = DynamicLabel.label("Class");
    private static final Label externalClassLabel = DynamicLabel.label("ExternalClass");
    private static final Label methodLabel = DynamicLabel.label("Method");
    private static final Label externalMethodLabel = DynamicLabel.label("ExternalMethod");
    private static final Label variableLabel = DynamicLabel.label("Variable");
    private static final Label argumentLabel = DynamicLabel.label("Argument");
    private static final Label externalArgumentLabel = DynamicLabel.label("ExternalArgument");
    private static final Label externalVariableLabel = DynamicLabel.label("ExternalVariable");
    private static final Label globalVariableLabel = DynamicLabel.label("GlobalVariable");
    private static final Label statementVariableLabel = DynamicLabel.label("StatementVariable");
    private static final Label functionLabel = DynamicLabel.label("Function");
    private static final Label statementLabel = DynamicLabel.label("Statement");
    private static final Label messageLabel = DynamicLabel.label("Message");



    private Map<Entity,Node> methodNodeMap;
    private Map<Entity,Node> classNodeMap;
    private Map<Entity,Node> variableNodeMap;
    private Map<PaprikaMessage,Node> messageNodeMap;
    private Map<PaprikaStatement,Node> statementNodeMap;
    private Map<PaprikaFunction,Node> functionNodeMap;
    private Map<Entity, Node> argumentNodeMap;

    private String key;

    public ModelToGraph(String DatabasePath){
        this.databaseManager = new DatabaseManager(DatabasePath);
        databaseManager.start();
        this.graphDatabaseService = databaseManager.getGraphDatabaseService();
        methodNodeMap = new HashMap<>();
        classNodeMap = new HashMap<>();
        variableNodeMap = new HashMap<>();
        messageNodeMap = new HashMap<>();
        statementNodeMap = new HashMap<>();
        functionNodeMap = new HashMap<>();
        argumentNodeMap =new HashMap<>();
        IndexManager indexManager = new IndexManager(graphDatabaseService);
        indexManager.createIndex();
    }

    public Node insertApp(PaprikaApp paprikaApp){
        this.key = paprikaApp.getAppKey();
        Node appNode;
        try ( Transaction tx = graphDatabaseService.beginTx() ){
            appNode = graphDatabaseService.createNode(appLabel);
            appNode.setProperty("app_key",key);
            appNode.setProperty("name",paprikaApp.getName());
            appNode.setProperty("category",paprikaApp.getCategory());
            Date date = new Date();
            SimpleDateFormat  simpleFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.S");
            appNode.setProperty("date_analysis", simpleFormat.format(date));
            for(PaprikaClass paprikaClass : paprikaApp.getPaprikaClasses()){
                appNode.createRelationshipTo(insertClass(paprikaClass),RelationTypes.APP_OWNS_CLASS);
            }
            for(PaprikaExternalClass paprikaExternalClass : paprikaApp.getPaprikaExternalClasses()){
                insertExternalClass(paprikaExternalClass);
            }
            Node tempNode;
            for(PaprikaFunction function : paprikaApp.getPaprikaFunctions()){
                tempNode = insertFunction(function);
                appNode.createRelationshipTo(tempNode,RelationTypes.APP_OWNS_FUNCTION);
            }
            for(PaprikaGlobalVariable variable : paprikaApp.getPaprikaGlobalVariables()){
                tempNode= insertGlobalVariable(variable);
                appNode.createRelationshipTo(tempNode,RelationTypes.APP_OWNS_GLOBAL_VARIABLE);
            }
            for(Metric metric : paprikaApp.getMetrics()){
                insertMetric(metric, appNode);
            }
            tx.success();
        }
        try ( Transaction tx = graphDatabaseService.beginTx() ){
            createLinks(paprikaApp);
            tx.success();
        }

        return appNode;
    }

    private void insertMetric(Metric metric, Node node) {
        node.setProperty(metric.getName(),metric.getValue());
    }


    public Node insertClass(PaprikaClass paprikaClass){
        Node classNode = graphDatabaseService.createNode(classLabel);
        classNodeMap.put(paprikaClass,classNode);
        classNode.setProperty("app_key",key);
        classNode.setProperty("name",paprikaClass.getName());
        classNode.setProperty("modifier", paprikaClass.getModifier().toString().toLowerCase());

        for(PaprikaVariable paprikaVariable : paprikaClass.getPaprikaVariables()){
            classNode.createRelationshipTo(insertVariable(paprikaVariable),RelationTypes.CLASS_OWNS_VARIABLE);

        }
        for(PaprikaMethod paprikaMethod : paprikaClass.getPaprikaMethods()){
            classNode.createRelationshipTo(insertMethod(paprikaMethod),RelationTypes.CLASS_OWNS_METHOD);
        }


        for(Metric metric : paprikaClass.getMetrics()){
            insertMetric(metric,classNode);
        }
        return classNode;
    }

   /* public Node insertBasicClass(PaprikaBasicClass paprikaClass, Node classNode){
        if(paprikaClass.getParentName() != null){
            classNode.setProperty("parent_name", paprikaClass.getParentName());
        }

        return classNode;
    }*/

    public Node insertExternalClass(PaprikaExternalClass paprikaClass){
        Node classNode = graphDatabaseService.createNode(externalClassLabel);
        classNodeMap.put(paprikaClass , classNode);
        Node tempNode;
        classNode.setProperty("app_key",key);
        classNode.setProperty("name",paprikaClass.getName());
        if(paprikaClass.getParentName() != null){
            classNode.setProperty("parent_name", paprikaClass.getParentName());
        }
        for(PaprikaExternalMethod paprikaExternalMethod : paprikaClass.getPaprikaExternalMethods()){
            classNode.createRelationshipTo(insertExternalMethod(paprikaExternalMethod),RelationTypes.CLASS_OWNS_METHOD);
        }

        for(Metric metric : paprikaClass.getMetrics()){
            insertMetric(metric,classNode);
        }
        return classNode;
    }

    public Node insertVariable(PaprikaVariable paprikaVariable){
        Node variableNode = graphDatabaseService.createNode(variableLabel);
        variableNodeMap.put(paprikaVariable,variableNode);
        variableNode.setProperty("app_key", key);
        variableNode.setProperty("name", paprikaVariable.getName());
        variableNode.setProperty("modifier", paprikaVariable.getModifier().toString().toLowerCase());
        variableNode.setProperty("type", paprikaVariable.getType());
        //TODO add the isGlobal metric
        for(Metric metric : paprikaVariable.getMetrics()){
            insertMetric(metric, variableNode);
        }
        return variableNode;
    }

    public Node insertGlobalVariable(PaprikaGlobalVariable paprikaVariable){
        Node variableNode = graphDatabaseService.createNode(globalVariableLabel);
        variableNodeMap.put(paprikaVariable, variableNode);
        variableNode.setProperty("app_key", key);
        variableNode.setProperty("name", paprikaVariable.getName());
        variableNode.setProperty("type", paprikaVariable.getType());
        return variableNode;
    }
    public Node insertFunction(PaprikaFunction paprikaFunction){
        Node variableNode = graphDatabaseService.createNode(functionLabel);
        functionNodeMap.put(paprikaFunction, variableNode);
        variableNode.setProperty("app_key", key);
        variableNode.setProperty("name", paprikaFunction.getName());
        variableNode.setProperty("return_type", paprikaFunction.getReturnType());
        for(Metric metric : paprikaFunction.getMetrics()){
            insertMetric(metric,variableNode);
        }
        return variableNode;
    }




    public Node insertMethod(PaprikaMethod paprikaMethod){
        Node methodNode = graphDatabaseService.createNode(methodLabel);
        methodNodeMap.put(paprikaMethod,methodNode);
        methodNode.setProperty("app_key", key);
        methodNode.setProperty("name",paprikaMethod.getName());
        methodNode.setProperty("modifier", paprikaMethod.getModifier().toString().toLowerCase());
        methodNode.setProperty("full_name",paprikaMethod.toString());
        methodNode.setProperty("return_type",paprikaMethod.getReturnType());
        for(Metric metric : paprikaMethod.getMetrics()){
            insertMetric(metric, methodNode);
        }
        for(PaprikaVariable paprikaVariable : paprikaMethod.getUsedVariables()){
            methodNode.createRelationshipTo(variableNodeMap.get(paprikaVariable),RelationTypes.USES);
        }
        for(PaprikaArgument arg : paprikaMethod.getArguments()){
            methodNode.createRelationshipTo(insertArgument(arg),RelationTypes.METHOD_OWNS_ARGUMENT);
        }

        return methodNode;
    }

    public Node insertExternalMethod(PaprikaExternalMethod paprikaMethod){
        Node methodNode = graphDatabaseService.createNode(externalMethodLabel);
        methodNodeMap.put(paprikaMethod,methodNode);
        methodNode.setProperty("app_key", key);
        methodNode.setProperty("name",paprikaMethod.getName());
        methodNode.setProperty("full_name",paprikaMethod.toString());
        methodNode.setProperty("return_type",paprikaMethod.getReturnType());
        for(Metric metric : paprikaMethod.getMetrics()){
            insertMetric(metric, methodNode);
        }
        for(PaprikaExternalArgument arg : paprikaMethod.getPaprikaExternalArguments()){
            methodNode.createRelationshipTo(insertExternalArgument(arg),RelationTypes.METHOD_OWNS_ARGUMENT);
        }
        return methodNode;
    }

    public Node insertArgument(PaprikaArgument paprikaArgument){
        Node argNode = graphDatabaseService.createNode(argumentLabel);
        argumentNodeMap.put(paprikaArgument, argNode);
        argNode.setProperty("app_key", key);
        argNode.setProperty("name", paprikaArgument.getName());
        argNode.setProperty("position", paprikaArgument.getPosition());
        return argNode;
    }

    public Node insertExternalArgument(PaprikaExternalArgument paprikaExternalArgument){
        Node argNode = graphDatabaseService.createNode(externalArgumentLabel);
        argumentNodeMap.put(paprikaExternalArgument, argNode);
        argNode.setProperty("app_key", key);
        argNode.setProperty("name", paprikaExternalArgument.getName());
        argNode.setProperty("position", paprikaExternalArgument.getPosition());
        return argNode;
    }

    public void createLinks(PaprikaApp paprikaApp){
        Node classNode;
        Node node;
        Node methodNode;
        for(PaprikaClass paprikaClass: paprikaApp.getPaprikaClasses()){
            classNode=classNodeMap.get(paprikaClass);

            if(paprikaClass instanceof PaprikaExtension && ((PaprikaExtension) paprikaClass).getExtendedClass()!=null){
                node=classNodeMap.get(((PaprikaExtension) paprikaClass).getExtendedClass());
                if(classNode!=null && node!=null)
                {
                    classNode.createRelationshipTo(node,RelationTypes.EXTENSION_OF);
                }
            }

            if(paprikaClass.getNestedClasses()!=null){
                for(PaprikaClass nestedClass: paprikaClass.getNestedClasses()){
                    node=classNodeMap.get(nestedClass);
                    if(classNode!=null && node!= null){
                        classNode.createRelationshipTo(node, RelationTypes.CLASS_NESTS_CLASS);
                    }
                }
            }

            if(paprikaClass.getInterfacesNames()!=null){
                for(PaprikaClass paprikaInterface: paprikaClass.getInterfaces()){
                    node= classNodeMap.get(paprikaInterface);
                    if(classNode!=null && node!= null) {
                        classNode.createRelationshipTo(node, RelationTypes.IMPLEMENTS);
                    }
                }
            }

            if(paprikaClass instanceof PaprikaBasicClass && ((PaprikaBasicClass) paprikaClass).getParent()!=null){
                node=classNodeMap.get(((PaprikaBasicClass) paprikaClass).getParent());
                if(classNode!=null && node!= null) {
                    classNode.createRelationshipTo(node, RelationTypes.EXTENDS);
                }
            }

            //methods links
            if(paprikaClass instanceof PaprikaBasicClass && !((PaprikaBasicClass) paprikaClass).getType().equals(PaprikaClassTypes.INTERFACE)){
                for(PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
                    methodNode=methodNodeMap.get(paprikaMethod);

                    if(paprikaMethod.getNestedEntities()!=null){
                        for(Entity entity:paprikaMethod.getNestedEntities()){
                            if(entity instanceof PaprikaClass){
                                node=classNodeMap.get(paprikaClass);
                                if(methodNode!=null && node!=null){
                                    methodNode.createRelationshipTo(classNode, RelationTypes.METHOD_NESTS_CLASS);
                                }
                            }else if(entity instanceof PaprikaMethod){
                                node=methodNodeMap.get(paprikaClass);
                                if(methodNode!=null && node!=null){
                                    methodNode.createRelationshipTo(classNode, RelationTypes.METHOD_NESTS_METHOD);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

  /*  public void createHierarchy(PaprikaApp paprikaApp) {
        for (PaprikaClass paprikaClass : paprikaApp.getPaprikaClasses()) {
            PaprikaClass parent = paprikaClass.getParent();
            if (parent != null) {
                classNodeMap.get(paprikaClass).createRelationshipTo(classNodeMap.get(parent),RelationTypes.EXTENDS);
            }
            for(PaprikaClass pInterface : paprikaClass.getInterfaces()){
                classNodeMap.get(paprikaClass).createRelationshipTo(classNodeMap.get(pInterface),RelationTypes.IMPLEMENTS);
            }
        }
    }*/

   /* public void createCallGraph(PaprikaApp paprikaApp) {
        Node tempNode;
        Node methodNode;
        for (PaprikaClass paprikaClass : paprikaApp.getPaprikaClasses()) {
            for (PaprikaMethod paprikaMethod : paprikaClass.getPaprikaMethods()){
                for(Entity calledMethod : paprikaMethod.getCalledMethods()){
                    if(methodNodeMap.get(calledMethod)!= null)
                    {
                        methodNodeMap.get(paprikaMethod).createRelationshipTo(methodNodeMap.get(calledMethod),RelationTypes.CALLS);
                    }
                }
                methodNode = methodNodeMap.get(paprikaMethod);
                for(PaprikaMessage message : paprikaMethod.getPaprikaMessages()){
                    tempNode = insertMessage(message);
                    methodNode.createRelationshipTo(tempNode,RelationTypes.METHOD_SENDS_MESSAGE);
                }
            }

            //add the relationship with the external classes
            if(paprikaClass.getParentName()!=null){
                //find the external class if it
            }
        }

       // insertObservesRelations();
    }*/
}
