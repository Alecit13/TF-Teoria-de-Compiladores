// Generated from TIME_FLOW.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TIME_FLOWParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TIME_FLOWVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TIME_FLOWParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#task_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTask_declaration(TIME_FLOWParser.Task_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#task_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTask_body(TIME_FLOWParser.Task_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#restriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestriction(TIME_FLOWParser.RestrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#execute_restriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_restriction(TIME_FLOWParser.Execute_restrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#conditional_restriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_restriction(TIME_FLOWParser.Conditional_restrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#temporal_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporal_condition(TIME_FLOWParser.Temporal_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#task_ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTask_ref(TIME_FLOWParser.Task_refContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#action_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction_body(TIME_FLOWParser.Action_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(TIME_FLOWParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TIME_FLOWParser#time_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_unit(TIME_FLOWParser.Time_unitContext ctx);
}