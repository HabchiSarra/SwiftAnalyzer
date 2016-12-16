package metrics;

import model.*;


import java.util.HashMap;

/**
 * Created by Sarra on 02/05/2016.
 */
public class MetricsCalculator {



    public static void calculateAppMetrics(PaprikaApp app)
    {
        int numberOfInterfaces=0;
        int numberOfExtensions =0;
        int numberOfStructs =0;
        int numberOfEnums = 0;
        for(PaprikaClass c: app.getPaprikaClasses()){
            calculateClassMetrics(c);
            if(c instanceof PaprikaExtension){
                numberOfExtensions++;
            }else if(c instanceof PaprikaBasicClass){
                if(((PaprikaBasicClass) c).getType().equals(PaprikaClassTypes.ENUM)){
                    numberOfEnums++;
                }else if (((PaprikaBasicClass) c).getType().equals(PaprikaClassTypes.INTERFACE)){
                    numberOfInterfaces++;
                }else if(((PaprikaBasicClass) c).getType().equals(PaprikaClassTypes.STRUCT)){
                    numberOfStructs++;
                }
            }

        }
        NumberOfInterfaces.createNumberOfInterfaces(app,numberOfInterfaces);
        NumberOfExtensions.createNumberOfExtensions(app,numberOfExtensions);
        NumberOfStructs.createNumberOfStructs(app,numberOfStructs);
        NumberOfEnums.createNumberOfEnums(app,numberOfEnums);
        NumberOfClasses.createNumberOfClasses(app,app.getPaprikaClasses().size());
        if(app.isCallsSynchronous()){
            IsCallingSynchronous.createIsCallingSynchronous(app);
        }
       // calculateGraphMetrics(app);
        for(PaprikaFunction paprikaFunction:app.getPaprikaFunctions()){
            calculateFunctionMetrics(paprikaFunction);
        }


    }


    public static void calculateClassMetrics(PaprikaClass paprikaClass){
        if(paprikaClass.isViewController())
        {
            IsViewController.createIsViewController(paprikaClass);
        }else if(paprikaClass.isInteractor()){
            IsInteractor.createIsInteractor(paprikaClass);
        }else if(paprikaClass.isRouter()){
            IsRouter.createIsRouter(paprikaClass);
        }else if(paprikaClass.isPresenter()){
            IsPresenter.createIsPresenter(paprikaClass);
        }

        NumberOfMethods.createNumberOfMethods(paprikaClass, paprikaClass.getPaprikaMethods().size());
        NumberOfImplementedInterfaces.createNumberOfImplementedInterfaces(paprikaClass,
                paprikaClass.getInterfaces().size());
        NumberOfAttributes.createNumberOfAttributes(paprikaClass, paprikaClass.getPaprikaVariables().size());

       // CAMCMetric.createCAMCMetric(paprikaClass);
        NumberOfLines.createNumberOfLines(paprikaClass, paprikaClass.getNumberOfLinesOfCode());
        //CouplingBetweenObjects.createCouplingBetweenObjects(paprikaClass);
        for(PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
            calculateMethodMetrics(paprikaMethod);
        }
        //this instruction must be called after the loop
        ClassComplexity.createClassComplexity(paprikaClass);

        if(paprikaClass instanceof PaprikaExtension){
            IsExtension.createIsExtension(paprikaClass);
        }else if(paprikaClass instanceof PaprikaBasicClass){
            //NumberOfChildren.createNumberOfChildren((PaprikaBasicClass) paprikaClass);
            if(((PaprikaBasicClass) paprikaClass).getType().equals(PaprikaClassTypes.ENUM)){
                IsEnum.createIsEnum(paprikaClass);
            }else if (((PaprikaBasicClass) paprikaClass).getType().equals(PaprikaClassTypes.INTERFACE)){
                IsInterface.createIsInterface(paprikaClass);
            }else if(((PaprikaBasicClass) paprikaClass).getType().equals(PaprikaClassTypes.STRUCT)){
                IsStruct.createIsStruct(paprikaClass);
            }
        }
    }

    public static void calculateMethodMetrics(PaprikaMethod paprikaMethod){
        NumberOfParameters.createNumberOfParameters(paprikaMethod, paprikaMethod.getArguments().size());

       if(paprikaMethod.isInit()){
            IsInit.createIsInit(paprikaMethod);
        }else if(paprikaMethod.isDeinit()){
           IsDeInit.createIsDeInit(paprikaMethod);
       }
        String methodName;
        boolean lookForSetter =false;
        //Checking if the method is a setter or a getter
        methodName=paprikaMethod.getName();
        if(paprikaMethod.getArguments().size()==1 && methodName.startsWith("set") ){
            methodName= paprikaMethod.getName().replace(":","");
            methodName = methodName.replace("set", "");
            lookForSetter=true;
        }
        String varName;
        if(lookForSetter || paprikaMethod.getArguments().size()==0) {
            for (PaprikaVariable paprikaVariable : paprikaMethod.getPaprikaClass().getPaprikaVariables()) {
                if(!lookForSetter) {
                    varName=paprikaVariable.getName();
                    varName =varName.replaceFirst("_","");
                    if (paprikaMethod.getName().equals(paprikaVariable.getName())|| paprikaMethod.getName().
                            equalsIgnoreCase("get"+paprikaVariable.getName()) || varName.equalsIgnoreCase(paprikaMethod.getName())
                            || paprikaMethod.getName().equalsIgnoreCase("get"+varName)) {
                        if(paprikaMethod.getReturnType().equals(paprikaVariable.getType()))
                        {
                            IsGetter.createIsGetter(paprikaMethod, true);
                            break;
                        }

                    }
                }else {
                    varName=paprikaVariable.getName();
                    varName =varName.replaceFirst("_","");
                    if (methodName.equalsIgnoreCase(paprikaVariable.getName()) || methodName.equalsIgnoreCase(varName) ) {
                        if(paprikaMethod.getArguments().get(0).getName().equals(paprikaVariable.getType())) {
                            IsSetter.createIsSetter(paprikaMethod, true);
                            break;
                        }
                    }
                }
            }
        }


        if(paprikaMethod.getStatic()){
            IsStatic.createIsStatic(paprikaMethod,true);
        }
       // NumberOfCallers.createNumberOfCallers(paprikaMethod,0);
        NumberOfLines.createNumberOfLines(paprikaMethod,paprikaMethod.getNumberOfLines());
        CyclomaticComplexity.createCyclomaticComplexity(paprikaMethod, paprikaMethod.getCyclomaticComplexity());
    }


    private static int calculateNumberOfDeclaredLocals(PaprikaStatement statement){
        int n= 0 ;
        n= statement.getVariables().size();
        for(PaprikaStatement st : statement.getChildrenStatements()){
            n=+ calculateNumberOfDeclaredLocals(st);
        }

        return n;

    }

    /*private static void calculateGraphMetrics(PaprikaApp app){
        HashMap<PaprikaMethod, Integer> numberOfCallers = new HashMap<>();
        Integer nb;
        for(PaprikaClass paprikaClass: app.getPaprikaClasses()){
            for (PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
                if(!numberOfCallers.containsKey(paprikaMethod)){
                    numberOfCallers.put(paprikaMethod,0);
                }
                for(Entity entity: paprikaMethod.getCalledMethods()){
                    if(entity instanceof PaprikaMethod){
                        nb=numberOfCallers.get((PaprikaMethod)entity);
                        if(nb==null){
                            numberOfCallers.put((PaprikaMethod)entity,1);
                        }else{
                            numberOfCallers.put((PaprikaMethod)entity,nb+1);
                        }
                    }
                }
            }
        }

        int depth;
        PaprikaClass paprikaClass2;
        for(PaprikaClass paprikaClass:app.getPaprikaClasses()){
            //calculate Depth Of Inheritance
            paprikaClass2=paprikaClass;
            depth=0;
            while(paprikaClass2.getParent() !=null){

                depth++;
                paprikaClass2=paprikaClass2.getParent();
            }
            if(paprikaClass2.getParentName()!=null){
                depth++;
            }
            DepthOfInheritance.createDepthOfInheritance(paprikaClass,depth);
            //calculate number of callers
            for(PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()){
                NumberOfCallers.createNumberOfCallers(paprikaMethod,numberOfCallers.get(paprikaMethod));
            }
        }
    }*/

    public static void calculateFunctionMetrics(PaprikaFunction paprikaFunction){
        NumberOfLines.createNumberOfLines(paprikaFunction, paprikaFunction.getNumberOfLines());
        CyclomaticComplexity.createCyclomaticComplexity(paprikaFunction, paprikaFunction.getCyclomaticComplexity());
    }
}
