// Generated from C:\Users\Sarra\IdeaProjects\artid2\src\main\antlr\Swift.g4 by ANTLR 4.2.2
package parser;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SwiftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SwiftVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolMethodDeclaration(@NotNull SwiftParser.ProtocolMethodDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#didSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDidSetClause(@NotNull SwiftParser.DidSetClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(@NotNull SwiftParser.FileNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#catchClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClauses(@NotNull SwiftParser.CatchClausesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#argumentName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentName(@NotNull SwiftParser.ArgumentNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnum(@NotNull SwiftParser.UnionStyleEnumContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(@NotNull SwiftParser.FunctionSignatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#extensionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionDeclaration(@NotNull SwiftParser.ExtensionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#associativityClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativityClause(@NotNull SwiftParser.AssociativityClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#arrayLiteralItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralItem(@NotNull SwiftParser.ArrayLiteralItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#classRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRequirement(@NotNull SwiftParser.ClassRequirementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(@NotNull SwiftParser.NumericLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#buildConfigurationElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfigurationElseClause(@NotNull SwiftParser.BuildConfigurationElseClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionCallWithClosureExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallWithClosureExpression(@NotNull SwiftParser.FunctionCallWithClosureExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolPropertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolPropertyDeclaration(@NotNull SwiftParser.ProtocolPropertyDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull SwiftParser.ArrayTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#argumentNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentNames(@NotNull SwiftParser.ArgumentNamesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(@NotNull SwiftParser.IdentifierListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#dictionaryType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryType(@NotNull SwiftParser.DictionaryTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalType(@NotNull SwiftParser.OptionalTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#requirementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementList(@NotNull SwiftParser.RequirementListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#wildcardPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardPattern(@NotNull SwiftParser.WildcardPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#sType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSType(@NotNull SwiftParser.STypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#externalParameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalParameterName(@NotNull SwiftParser.ExternalParameterNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#closureExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosureExpression(@NotNull SwiftParser.ClosureExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#buildConfigurationElseIfClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfigurationElseIfClause(@NotNull SwiftParser.BuildConfigurationElseIfClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#variableDeclarationHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationHead(@NotNull SwiftParser.VariableDeclarationHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#lineNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineNumber(@NotNull SwiftParser.LineNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnumCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnumCase(@NotNull SwiftParser.RawValueStyleEnumCaseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(@NotNull SwiftParser.StructDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#implicitlyUnwrappedOptionalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitlyUnwrappedOptionalType(@NotNull SwiftParser.ImplicitlyUnwrappedOptionalTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(@NotNull SwiftParser.ArrayLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#dictionaryLiteralItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteralItem(@NotNull SwiftParser.DictionaryLiteralItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#postfixSelfExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixSelfExpression(@NotNull SwiftParser.PostfixSelfExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(@NotNull SwiftParser.ReturnStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolMemberDeclaration(@NotNull SwiftParser.ProtocolMemberDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull SwiftParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolIdentifierList(@NotNull SwiftParser.ProtocolIdentifierListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#guardStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardStatement(@NotNull SwiftParser.GuardStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull SwiftParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(@NotNull SwiftParser.FunctionCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(@NotNull SwiftParser.AttributeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#labelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelName(@NotNull SwiftParser.LabelNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#accessLevelModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessLevelModifiers(@NotNull SwiftParser.AccessLevelModifiersContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteral(@NotNull SwiftParser.DictionaryLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(@NotNull SwiftParser.ConstantDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(@NotNull SwiftParser.EnumDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#getterSetterKeywordBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterSetterKeywordBlock(@NotNull SwiftParser.GetterSetterKeywordBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(@NotNull SwiftParser.PrimaryExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull SwiftParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(@NotNull SwiftParser.ThrowStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#enumDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDef(@NotNull SwiftParser.EnumDefContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull SwiftParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalBindingHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalBindingHead(@NotNull SwiftParser.OptionalBindingHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalBindingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalBindingCondition(@NotNull SwiftParser.OptionalBindingConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#importKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportKind(@NotNull SwiftParser.ImportKindContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#buildConfigurationElseIfClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfigurationElseIfClauses(@NotNull SwiftParser.BuildConfigurationElseIfClausesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#forcedValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForcedValueExpression(@NotNull SwiftParser.ForcedValueExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevel(@NotNull SwiftParser.TopLevelContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#implicitMemberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitMemberExpression(@NotNull SwiftParser.ImplicitMemberExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(@NotNull SwiftParser.IntegerLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#captureSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureSpecifier(@NotNull SwiftParser.CaptureSpecifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolCompositionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolCompositionType(@NotNull SwiftParser.ProtocolCompositionTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#buildConfigurationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfigurationStatement(@NotNull SwiftParser.BuildConfigurationStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tupleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleType(@NotNull SwiftParser.TupleTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAnnotation(@NotNull SwiftParser.TypeAnnotationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull SwiftParser.OperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalChainingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalChainingExpression(@NotNull SwiftParser.OptionalChainingExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnumCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnumCaseClause(@NotNull SwiftParser.RawValueStyleEnumCaseClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#operatorCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorCharacter(@NotNull SwiftParser.OperatorCharacterContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#prefixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperator(@NotNull SwiftParser.PrefixOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#associativity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociativity(@NotNull SwiftParser.AssociativityContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(@NotNull SwiftParser.KeywordContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull SwiftParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#availabilityArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvailabilityArgument(@NotNull SwiftParser.AvailabilityArgumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#selectorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorExpression(@NotNull SwiftParser.SelectorExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#dynamicTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicTypeExpression(@NotNull SwiftParser.DynamicTypeExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#patternInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternInitializerList(@NotNull SwiftParser.PatternInitializerListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeInheritanceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInheritanceClause(@NotNull SwiftParser.TypeInheritanceClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnum(@NotNull SwiftParser.RawValueStyleEnumContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnumCaseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnumCaseList(@NotNull SwiftParser.UnionStyleEnumCaseListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolIdentifier(@NotNull SwiftParser.ProtocolIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#captureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureList(@NotNull SwiftParser.CaptureListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#setterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterName(@NotNull SwiftParser.SetterNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(@NotNull SwiftParser.ParameterListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#declarationModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationModifiers(@NotNull SwiftParser.DeclarationModifiersContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHead(@NotNull SwiftParser.FunctionHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolMemberDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolMemberDeclarations(@NotNull SwiftParser.ProtocolMemberDeclarationsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#precedenceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedenceClause(@NotNull SwiftParser.PrecedenceClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tuplePatternElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuplePatternElementList(@NotNull SwiftParser.TuplePatternElementListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnumMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnumMembers(@NotNull SwiftParser.UnionStyleEnumMembersContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#closureSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosureSignature(@NotNull SwiftParser.ClosureSignatureContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#importPathIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPathIdentifier(@NotNull SwiftParser.ImportPathIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#captureListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureListItem(@NotNull SwiftParser.CaptureListItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#conformanceRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConformanceRequirement(@NotNull SwiftParser.ConformanceRequirementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolName(@NotNull SwiftParser.ProtocolNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#platformVersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlatformVersion(@NotNull SwiftParser.PlatformVersionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnumCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnumCaseClause(@NotNull SwiftParser.UnionStyleEnumCaseClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#enumCaseName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumCaseName(@NotNull SwiftParser.EnumCaseNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolSubscriptDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolSubscriptDeclaration(@NotNull SwiftParser.ProtocolSubscriptDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#infixOperatorAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOperatorAttributes(@NotNull SwiftParser.InfixOperatorAttributesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull SwiftParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#asPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsPattern(@NotNull SwiftParser.AsPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#attributeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(@NotNull SwiftParser.AttributeNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#requirementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementClause(@NotNull SwiftParser.RequirementClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#controlTransferStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlTransferStatement(@NotNull SwiftParser.ControlTransferStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#platformName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlatformName(@NotNull SwiftParser.PlatformNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typealiasHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypealiasHead(@NotNull SwiftParser.TypealiasHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnumMember(@NotNull SwiftParser.UnionStyleEnumMemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(@NotNull SwiftParser.VariableNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#postfixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperator(@NotNull SwiftParser.PostfixOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#fallthroughStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallthroughStatement(@NotNull SwiftParser.FallthroughStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#declarationModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationModifier(@NotNull SwiftParser.DeclarationModifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#patternInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternInitializer(@NotNull SwiftParser.PatternInitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(@NotNull SwiftParser.LoopStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull SwiftParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#setterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterClause(@NotNull SwiftParser.SetterClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericParameter(@NotNull SwiftParser.GenericParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericParameterList(@NotNull SwiftParser.GenericParameterListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(@NotNull SwiftParser.WhileStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#setterKeywordClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterKeywordClause(@NotNull SwiftParser.SetterKeywordClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#postfixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperation(@NotNull SwiftParser.PostfixOperationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#structName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructName(@NotNull SwiftParser.StructNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#classDeclarationModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationModifiers(@NotNull SwiftParser.ClassDeclarationModifiersContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(@NotNull SwiftParser.FunctionBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeInheritanceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInheritanceList(@NotNull SwiftParser.TypeInheritanceListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tupleTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeBody(@NotNull SwiftParser.TupleTypeBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#postfixOperatorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperatorDeclaration(@NotNull SwiftParser.PostfixOperatorDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#infixOperatorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixOperatorDeclaration(@NotNull SwiftParser.InfixOperatorDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#caseCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseCondition(@NotNull SwiftParser.CaseConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericArgument(@NotNull SwiftParser.GenericArgumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeArgumentClause(@NotNull SwiftParser.AttributeArgumentClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#precedenceLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedenceLevel(@NotNull SwiftParser.PrecedenceLevelContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#operatingSystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatingSystem(@NotNull SwiftParser.OperatingSystemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#explicitMemberExpression1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitMemberExpression1(@NotNull SwiftParser.ExplicitMemberExpression1Context ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#conditionalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOperator(@NotNull SwiftParser.ConditionalOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(@NotNull SwiftParser.ParenthesizedExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tupleTypeElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeElement(@NotNull SwiftParser.TupleTypeElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#superclassInitializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclassInitializerExpression(@NotNull SwiftParser.SuperclassInitializerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#explicitMemberExpression3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitMemberExpression3(@NotNull SwiftParser.ExplicitMemberExpression3Context ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#explicitMemberExpression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitMemberExpression2(@NotNull SwiftParser.ExplicitMemberExpression2Context ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializerExpressionWithArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerExpressionWithArguments(@NotNull SwiftParser.InitializerExpressionWithArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#defaultLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLabel(@NotNull SwiftParser.DefaultLabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#platformTestingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlatformTestingFunction(@NotNull SwiftParser.PlatformTestingFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull SwiftParser.IdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#caseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseItem(@NotNull SwiftParser.CaseItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#captureListItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureListItems(@NotNull SwiftParser.CaptureListItemsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#deferStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferStatement(@NotNull SwiftParser.DeferStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#whereExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereExpression(@NotNull SwiftParser.WhereExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typealiasDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypealiasDeclaration(@NotNull SwiftParser.TypealiasDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tupleTypeElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleTypeElementList(@NotNull SwiftParser.TupleTypeElementListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#selfExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfExpression(@NotNull SwiftParser.SelfExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#switchCases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCases(@NotNull SwiftParser.SwitchCasesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#inOutExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOutExpression(@NotNull SwiftParser.InOutExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(@NotNull SwiftParser.TypeIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializerHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerHead(@NotNull SwiftParser.InitializerHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull SwiftParser.PrimaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#contextSensitiveKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextSensitiveKeyword(@NotNull SwiftParser.ContextSensitiveKeywordContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#balancedToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalancedToken(@NotNull SwiftParser.BalancedTokenContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#expressionElementIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionElementIdentifier(@NotNull SwiftParser.ExpressionElementIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(@NotNull SwiftParser.ElseClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typealiasAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypealiasAssignment(@NotNull SwiftParser.TypealiasAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tuplePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuplePattern(@NotNull SwiftParser.TuplePatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#subscriptExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptExpression(@NotNull SwiftParser.SubscriptExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnumMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnumMembers(@NotNull SwiftParser.RawValueStyleEnumMembersContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueAssignment(@NotNull SwiftParser.RawValueAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(@NotNull SwiftParser.PatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(@NotNull SwiftParser.TypeNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#availabilityArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvailabilityArguments(@NotNull SwiftParser.AvailabilityArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(@NotNull SwiftParser.ClassNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#isPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsPattern(@NotNull SwiftParser.IsPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#subscriptDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptDeclaration(@NotNull SwiftParser.SubscriptDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#expressionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionElement(@NotNull SwiftParser.ExpressionElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#caseLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseLabel(@NotNull SwiftParser.CaseLabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#repeatWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatWhileStatement(@NotNull SwiftParser.RepeatWhileStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(@NotNull SwiftParser.CatchClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#balancedTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalancedTokens(@NotNull SwiftParser.BalancedTokensContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(@NotNull SwiftParser.LabeledStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#metatypeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetatypeType(@NotNull SwiftParser.MetatypeTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#operatorHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorHead(@NotNull SwiftParser.OperatorHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#superclassSubscriptExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclassSubscriptExpression(@NotNull SwiftParser.SuperclassSubscriptExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#architecture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchitecture(@NotNull SwiftParser.ArchitectureContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#valueBindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueBindingPattern(@NotNull SwiftParser.ValueBindingPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#localParameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalParameterName(@NotNull SwiftParser.LocalParameterNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#availabilityCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvailabilityCondition(@NotNull SwiftParser.AvailabilityConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(@NotNull SwiftParser.InitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(@NotNull SwiftParser.VariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(@NotNull SwiftParser.DoStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#unionStyleEnumCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionStyleEnumCase(@NotNull SwiftParser.UnionStyleEnumCaseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#wildcardExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardExpression(@NotNull SwiftParser.WildcardExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(@NotNull SwiftParser.BinaryOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#forInStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInStatement(@NotNull SwiftParser.ForInStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(@NotNull SwiftParser.AttributesContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#willSetDidSetBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWillSetDidSetBlock(@NotNull SwiftParser.WillSetDidSetBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull SwiftParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#buildConfiguration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildConfiguration(@NotNull SwiftParser.BuildConfigurationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializerBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerBody(@NotNull SwiftParser.InitializerBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(@NotNull SwiftParser.WhereClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#expressionElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionElementList(@NotNull SwiftParser.ExpressionElementListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#compilerControlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilerControlStatement(@NotNull SwiftParser.CompilerControlStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tuplePatternElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuplePatternElement(@NotNull SwiftParser.TuplePatternElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(@NotNull SwiftParser.AssignmentOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalBindingContinuationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalBindingContinuationList(@NotNull SwiftParser.OptionalBindingContinuationListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#conditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionClause(@NotNull SwiftParser.ConditionClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#operatorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorDeclaration(@NotNull SwiftParser.OperatorDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#elementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementName(@NotNull SwiftParser.ElementNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#superclassExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclassExpression(@NotNull SwiftParser.SuperclassExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#conditionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionList(@NotNull SwiftParser.ConditionListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#arrayLiteralItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralItems(@NotNull SwiftParser.ArrayLiteralItemsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#getterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterClause(@NotNull SwiftParser.GetterClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(@NotNull SwiftParser.CodeBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#dictionaryLiteralItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteralItems(@NotNull SwiftParser.DictionaryLiteralItemsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#sameTypeRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSameTypeRequirement(@NotNull SwiftParser.SameTypeRequirementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#accessLevelModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessLevelModifier(@NotNull SwiftParser.AccessLevelModifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#parameterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterClause(@NotNull SwiftParser.ParameterClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#extensionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionBody(@NotNull SwiftParser.ExtensionBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolDeclaration(@NotNull SwiftParser.ProtocolDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#subscriptResult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptResult(@NotNull SwiftParser.SubscriptResultContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeCastingOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCastingOperator(@NotNull SwiftParser.TypeCastingOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnumMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnumMember(@NotNull SwiftParser.RawValueStyleEnumMemberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typeCastingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCastingPattern(@NotNull SwiftParser.TypeCastingPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(@NotNull SwiftParser.BinaryExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull SwiftParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericArgumentClause(@NotNull SwiftParser.GenericArgumentClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionResult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionResult(@NotNull SwiftParser.FunctionResultContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#willSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWillSetClause(@NotNull SwiftParser.WillSetClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#getterSetterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterSetterBlock(@NotNull SwiftParser.GetterSetterBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#typealiasName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypealiasName(@NotNull SwiftParser.TypealiasNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#optionalBindingContinuation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalBindingContinuation(@NotNull SwiftParser.OptionalBindingContinuationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#enumName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumName(@NotNull SwiftParser.EnumNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#branchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStatement(@NotNull SwiftParser.BranchStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#switchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(@NotNull SwiftParser.SwitchCaseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#importPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPath(@NotNull SwiftParser.ImportPathContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolAssociatedTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolAssociatedTypeDeclaration(@NotNull SwiftParser.ProtocolAssociatedTypeDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericParameterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericParameterClause(@NotNull SwiftParser.GenericParameterClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#genericArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericArgumentList(@NotNull SwiftParser.GenericArgumentListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#enumCasePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumCasePattern(@NotNull SwiftParser.EnumCasePatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull SwiftParser.StatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolBody(@NotNull SwiftParser.ProtocolBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(@NotNull SwiftParser.SwitchStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#tryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryOperator(@NotNull SwiftParser.TryOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull SwiftParser.ClassDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#prefixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(@NotNull SwiftParser.PrefixExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull SwiftParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#expressionPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPattern(@NotNull SwiftParser.ExpressionPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#languageVersionTestingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageVersionTestingFunction(@NotNull SwiftParser.LanguageVersionTestingFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#protocolInitializerDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProtocolInitializerDeclaration(@NotNull SwiftParser.ProtocolInitializerDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializerDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerDeclaration(@NotNull SwiftParser.InitializerDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(@NotNull SwiftParser.ImportDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#getterKeywordClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterKeywordClause(@NotNull SwiftParser.GetterKeywordClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#rawValueStyleEnumCaseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawValueStyleEnumCaseList(@NotNull SwiftParser.RawValueStyleEnumCaseListContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#lineControlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineControlStatement(@NotNull SwiftParser.LineControlStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#statementLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLabel(@NotNull SwiftParser.StatementLabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(@NotNull SwiftParser.FunctionNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#structBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBody(@NotNull SwiftParser.StructBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(@NotNull SwiftParser.BreakStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#deinitializerDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeinitializerDeclaration(@NotNull SwiftParser.DeinitializerDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(@NotNull SwiftParser.RequirementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(@NotNull SwiftParser.DeclarationsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#subscriptHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptHead(@NotNull SwiftParser.SubscriptHeadContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#prefixOperatorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperatorDeclaration(@NotNull SwiftParser.PrefixOperatorDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#identifierPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPattern(@NotNull SwiftParser.IdentifierPatternContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerExpression(@NotNull SwiftParser.InitializerExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#swiftVersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwiftVersion(@NotNull SwiftParser.SwiftVersionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(@NotNull SwiftParser.ContinueStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#defaultArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultArgumentClause(@NotNull SwiftParser.DefaultArgumentClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(@NotNull SwiftParser.LiteralExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#superclassMethodExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclassMethodExpression(@NotNull SwiftParser.SuperclassMethodExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SwiftParser#caseItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseItemList(@NotNull SwiftParser.CaseItemListContext ctx);
}