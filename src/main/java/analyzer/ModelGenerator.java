package analyzer;

import model.*;
import org.antlr.v4.runtime.misc.NotNull;
import parser.SwiftBaseListener;
import parser.SwiftParser;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Sarra on 08/06/2016.
 */
public class ModelGenerator extends SwiftBaseListener {

    PaprikaApp app;
  // private PaprikaStatement currentStatement;
    private Stack<PaprikaClass> classStack;
    private Stack<Entity> methodStack;

    public ModelGenerator(PaprikaApp app) {
        this.app = app;
     //   currentStatement = null;
        classStack=new Stack<PaprikaClass>();
        methodStack= new Stack<>();
    }

    @Override public void enterClassDeclaration(@NotNull SwiftParser.ClassDeclarationContext ctx) {
        if(ctx.className()!=null){
            String className= ctx.className().identifier().getText();
            //create a class with this name
            PaprikaBasicClass paprikaClass =PaprikaBasicClass.createPaprikaBasicClass(className,PaprikaClassTypes.CLASS, this.app);
            classStack.push(paprikaClass);

            //Inheritance and implementation
            if(ctx.typeInheritanceClause()!=null && ctx.typeInheritanceClause().typeInheritanceList()!=null
                    && ctx.typeInheritanceClause().typeInheritanceList().typeIdentifier()!=null){
                for(SwiftParser.TypeIdentifierContext type: ctx.typeInheritanceClause().
                        typeInheritanceList().typeIdentifier()){
                    if(type.typeName()!=null){
                        paprikaClass.addInterfaceName(type.typeName().identifier().getText());
                    }
                }
            }


        }
    }
    @Override public void exitClassDeclaration(@NotNull SwiftParser.ClassDeclarationContext ctx) {
        try{
            classStack.pop();
        }catch (EmptyStackException ese){
            //Uknown case
            ese.printStackTrace();
        }
    }
    @Override public void enterStructDeclaration(@NotNull SwiftParser.StructDeclarationContext ctx) {
        if(ctx.structName()!=null){
            String className= ctx.structName().identifier().getText();
            //create a structure with this name
            System.out.println("Class: "+ className);
            PaprikaBasicClass paprikaClass=PaprikaBasicClass.createPaprikaBasicClass(className,PaprikaClassTypes.STRUCT,  this.app);
            classStack.push(paprikaClass);

            //Implementation
            if(ctx.typeInheritanceClause()!=null && ctx.typeInheritanceClause().typeInheritanceList()!=null
                    && ctx.typeInheritanceClause().typeInheritanceList().typeIdentifier()!=null){
                for(SwiftParser.TypeIdentifierContext type: ctx.typeInheritanceClause().
                        typeInheritanceList().typeIdentifier()){
                    if(type.typeName()!=null){
                        paprikaClass.addInterfaceName(type.typeName().identifier().getText());
                    }
                }
            }
        }
    }

    @Override public void exitStructDeclaration(@NotNull SwiftParser.StructDeclarationContext ctx) {
        try{
            classStack.pop();
        }catch (EmptyStackException ese){
            //Uknown case
            ese.printStackTrace();
        }
    }
    @Override public void enterFunctionDeclaration(@NotNull SwiftParser.FunctionDeclarationContext ctx) {

        if(ctx.functionName()!=null){
            String functionName= ctx.functionName().getText();

            //Retrieving the return type
            String returnType= "void";
            if(ctx.functionSignature()!= null){
                if(ctx.functionSignature().functionResult()!=null){
                    if(ctx.functionSignature().functionResult().sType()!=null){
                        returnType = ctx.functionSignature().functionResult().sType().getText();
                    }
                }
            }
            //Checking if it's static or no
            boolean staticFunc = false;
            if(ctx.functionHead()!=null){
                if(ctx.functionHead().declarationModifiers()!=null){
                    for(SwiftParser.DeclarationModifierContext declarationModifierContext:
                            ctx.functionHead().declarationModifiers().declarationModifier()){
                        if(declarationModifierContext.getText().equals("static")|| declarationModifierContext.getText().equals("class")){
                            staticFunc=true;
                            break;
                        }
                    }
                }
            }

            if(!classStack.isEmpty()){//It is a method
                PaprikaMethod paprikaMethod =PaprikaMethod.createPaprikaMethod(functionName, returnType,classStack.peek(),false,staticFunc);
                //check if it's a nested method
                if(!methodStack.isEmpty() ){
                    //check if it's not a nested class
                    if(methodStack.peek() instanceof PaprikaFunction){
                        //It's a class nested inside a function
                    }else{
                        if(((PaprikaMethod)methodStack.peek()).getPaprikaClass() == classStack.peek()){
                            //it's a nested method
                            ((PaprikaMethod)methodStack.peek()).addNestedEntity(paprikaMethod);
                        }else{
                            //it's a class nested inside a method
                        }
                    }

                }
                methodStack.push(paprikaMethod);
                //Retrieving the parameters
                if(ctx.functionSignature()!=null && ctx.functionSignature().parameterClause()!=null &&
                        ctx.functionSignature().parameterClause().parameterList()!=null &&
                        ctx.functionSignature().parameterClause().parameterList().parameter()!=null){

                    int countParameter = 0;
                    for(SwiftParser.ParameterContext parameter: ctx.functionSignature().parameterClause().parameterList().parameter()){
                        if(parameter.sType()!=null){
                            //TODO why there is no local name
                            PaprikaArgument.createPaprikaArgument(parameter.sType().getText(),countParameter,"",((PaprikaMethod)methodStack.peek()));
                        }else if(parameter.typeAnnotation()!=null){
                            PaprikaArgument.createPaprikaArgument(parameter.typeAnnotation().sType().getText(),
                                    countParameter,parameter.localParameterName().getText(), ((PaprikaMethod)methodStack.peek()));
                        }
                        countParameter++;
                    }

                }
            }else{//It is a function
                PaprikaFunction paprikaFunction= PaprikaFunction.createPaprikaFunction(functionName,returnType,this.app);
                //Check if it's a nested function
                if(!methodStack.isEmpty()){
                    ((PaprikaFunction)methodStack.peek()).addNestedEntity(paprikaFunction);
                }
                this.methodStack.push(paprikaFunction);
                //TODO add arguments to the functions

            }
        }
    }

    @Override public void exitFunctionDeclaration(@NotNull SwiftParser.FunctionDeclarationContext ctx) {
        try{
            methodStack.pop();
        }catch(EmptyStackException ese){
            ese.printStackTrace();
        }
    }

    @Override public void enterVariableDeclaration(@NotNull SwiftParser.VariableDeclarationContext ctx) {
        if(ctx.variableName()!=null){
            String varName = ctx.variableName().getText();
            String type ="";
            if(ctx.typeAnnotation()!=null && ctx.typeAnnotation().sType()!=null){
                type = ctx.typeAnnotation().sType().getText();
            }

            //Retrieving the modifier
            PaprikaModifiers paprikaModifiers= PaprikaModifiers.INTERNAL;
            if(ctx.variableDeclarationHead()!=null && ctx.variableDeclarationHead().declarationModifiers()!=null &&
                    ctx.variableDeclarationHead().declarationModifiers().declarationModifier()!=null){
                for(SwiftParser.DeclarationModifierContext declarationModifier:ctx.variableDeclarationHead().
                        declarationModifiers().declarationModifier() ){
                    if(declarationModifier.accessLevelModifier()!=null){
                        if(declarationModifier.accessLevelModifier().getText().contains("private")){
                            paprikaModifiers=PaprikaModifiers.PRIVATE;
                        }else if(declarationModifier.accessLevelModifier().getText().contains("public")){
                            paprikaModifiers=PaprikaModifiers.PUBLIC;
                        }
                        break;
                    }
                }
            }
            if(!classStack.isEmpty()){
                PaprikaVariable.createPaprikaVariable(varName,type,paprikaModifiers,classStack.peek());
            }else{//It's a global variable
                PaprikaGlobalVariable.createPaprikaGlobalVariable(varName,type,this.app);
            }

        }else {
            //TODO: Uknown case
        }
    }


    @Override public void enterEnumDeclaration(@NotNull SwiftParser.EnumDeclarationContext ctx) {

        if(ctx.enumDef()!=null){
            if(ctx.enumDef().unionStyleEnum()!=null){
                if(ctx.enumDef().unionStyleEnum().enumName()!=null){
                    //create a class
                    PaprikaBasicClass paprikaClass =PaprikaBasicClass.createPaprikaBasicClass(ctx.enumDef().unionStyleEnum().enumName().
                            identifier().getText(),PaprikaClassTypes.ENUM,this.app);
                    //Check if it's a nested class
                    if(!classStack.isEmpty()){
                        PaprikaClass nesterClass = classStack.peek();
                        nesterClass.addNestedClass(paprikaClass);
                    }
                    classStack.push(paprikaClass);
                    //Implementation
                    if(ctx.enumDef().unionStyleEnum().typeInheritanceClause()!=null && ctx.enumDef().unionStyleEnum().
                            typeInheritanceClause().typeInheritanceList()!=null && ctx.enumDef().unionStyleEnum().typeInheritanceClause()
                            .typeInheritanceList().typeIdentifier()!=null){
                        for(SwiftParser.TypeIdentifierContext type: ctx.enumDef().unionStyleEnum().typeInheritanceClause().
                                typeInheritanceList().typeIdentifier()){
                            if(type.typeName()!=null){
                                paprikaClass.addInterfaceName(type.typeName().identifier().getText());
                            }
                        }
                    }
                }
            }else if(ctx.enumDef().rawValueStyleEnum()!=null){
                if(ctx.enumDef().rawValueStyleEnum().enumName()!=null){
                    //create a class
                    PaprikaBasicClass paprikaClass =PaprikaBasicClass.createPaprikaBasicClass(ctx.enumDef().rawValueStyleEnum().enumName().
                            identifier().getText(), PaprikaClassTypes.ENUM, this.app);
                    if(!classStack.isEmpty()){
                        PaprikaClass nesterClass = classStack.peek();
                        nesterClass.addNestedClass(paprikaClass);
                    }
                    classStack.push(paprikaClass);
                    //Implementation
                    if(ctx.enumDef().unionStyleEnum().typeInheritanceClause()!=null && ctx.enumDef().unionStyleEnum().
                            typeInheritanceClause().typeInheritanceList()!=null && ctx.enumDef().unionStyleEnum().typeInheritanceClause()
                            .typeInheritanceList().typeIdentifier()!=null){
                        for(SwiftParser.TypeIdentifierContext type: ctx.enumDef().unionStyleEnum().typeInheritanceClause().
                                typeInheritanceList().typeIdentifier()){
                            if(type.typeName()!=null){
                                paprikaClass.addInterfaceName(type.typeName().identifier().getText());
                            }
                        }
                    }
                }
            }
        }
    }



    @Override public void exitEnumDeclaration(@NotNull SwiftParser.EnumDeclarationContext ctx) {
        try{
            classStack.pop();
        }catch (EmptyStackException ese){
            //Uknown case
            ese.printStackTrace();
        }
    }


    @Override public void enterProtocolDeclaration(@NotNull SwiftParser.ProtocolDeclarationContext ctx) {
        if(ctx.protocolName()!=null){
            //create an interface
            PaprikaBasicClass paprikaClass=PaprikaBasicClass.createPaprikaBasicClass(ctx.protocolName().identifier().getText(),PaprikaClassTypes.INTERFACE,this.app);
            if(!classStack.isEmpty()){
                PaprikaClass nesterClass = classStack.peek();
                nesterClass.addNestedClass(paprikaClass);
            }
            classStack.push(paprikaClass);
            //Inheritance
            if(ctx.typeInheritanceClause()!=null && ctx.typeInheritanceClause().typeInheritanceList()!=null
                    && ctx.typeInheritanceClause().typeInheritanceList().typeIdentifier()!=null){
                for(SwiftParser.TypeIdentifierContext type: ctx.typeInheritanceClause().
                        typeInheritanceList().typeIdentifier()){
                    if(type.typeName()!=null){
                        paprikaClass.addInterfaceName(type.typeName().identifier().getText());
                    }
                }
            }
        }
    }

    @Override public void enterExtensionDeclaration(@NotNull SwiftParser.ExtensionDeclarationContext ctx) {
        if(ctx.typeIdentifier() != null){
            //The extension takes the same name as the extended class or protocol
            PaprikaExtension extension =PaprikaExtension.createPaprikaExtension(ctx.typeIdentifier().typeName().identifier().getText(), this.app);
            if(!classStack.isEmpty()){
                PaprikaClass nesterClass = classStack.peek();
                nesterClass.addNestedClass(extension);
            }
            classStack.push(extension);
            //Add protocols
            if(ctx.typeInheritanceClause()!=null && ctx.typeInheritanceClause().typeInheritanceList()!=null &&
                    ctx.typeInheritanceClause().typeInheritanceList().typeIdentifier()!=null){
                for(SwiftParser.TypeIdentifierContext type : ctx.typeInheritanceClause().typeInheritanceList().typeIdentifier()){
                    extension.addInterfaceName(type.typeName().identifier().getText());
                }

            }
        }
    }

    @Override public void exitProtocolDeclaration(@NotNull SwiftParser.ProtocolDeclarationContext ctx) {
        try{
            classStack.pop();
        }catch (EmptyStackException ese){
            //Uknown case
            ese.printStackTrace();
        }
    }

    @Override public void exitExtensionDeclaration(@NotNull SwiftParser.ExtensionDeclarationContext ctx) {
        try{
            classStack.pop();
        }catch (EmptyStackException ese){
            //Uknown case
            ese.printStackTrace();
        }
    }
}
