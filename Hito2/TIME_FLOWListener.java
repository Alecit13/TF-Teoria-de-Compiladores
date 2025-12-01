// Generated from TIME_FLOW.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TIME_FLOWParser}.
 */
public interface TIME_FLOWListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TIME_FLOWParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TIME_FLOWParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#task_declaration}.
	 * @param ctx the parse tree
	 */
	void enterTask_declaration(TIME_FLOWParser.Task_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#task_declaration}.
	 * @param ctx the parse tree
	 */
	void exitTask_declaration(TIME_FLOWParser.Task_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#task_body}.
	 * @param ctx the parse tree
	 */
	void enterTask_body(TIME_FLOWParser.Task_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#task_body}.
	 * @param ctx the parse tree
	 */
	void exitTask_body(TIME_FLOWParser.Task_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#restriction}.
	 * @param ctx the parse tree
	 */
	void enterRestriction(TIME_FLOWParser.RestrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#restriction}.
	 * @param ctx the parse tree
	 */
	void exitRestriction(TIME_FLOWParser.RestrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#execute_restriction}.
	 * @param ctx the parse tree
	 */
	void enterExecute_restriction(TIME_FLOWParser.Execute_restrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#execute_restriction}.
	 * @param ctx the parse tree
	 */
	void exitExecute_restriction(TIME_FLOWParser.Execute_restrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#conditional_restriction}.
	 * @param ctx the parse tree
	 */
	void enterConditional_restriction(TIME_FLOWParser.Conditional_restrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#conditional_restriction}.
	 * @param ctx the parse tree
	 */
	void exitConditional_restriction(TIME_FLOWParser.Conditional_restrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#temporal_condition}.
	 * @param ctx the parse tree
	 */
	void enterTemporal_condition(TIME_FLOWParser.Temporal_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#temporal_condition}.
	 * @param ctx the parse tree
	 */
	void exitTemporal_condition(TIME_FLOWParser.Temporal_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#task_ref}.
	 * @param ctx the parse tree
	 */
	void enterTask_ref(TIME_FLOWParser.Task_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#task_ref}.
	 * @param ctx the parse tree
	 */
	void exitTask_ref(TIME_FLOWParser.Task_refContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#action_body}.
	 * @param ctx the parse tree
	 */
	void enterAction_body(TIME_FLOWParser.Action_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#action_body}.
	 * @param ctx the parse tree
	 */
	void exitAction_body(TIME_FLOWParser.Action_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(TIME_FLOWParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(TIME_FLOWParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TIME_FLOWParser#time_unit}.
	 * @param ctx the parse tree
	 */
	void enterTime_unit(TIME_FLOWParser.Time_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TIME_FLOWParser#time_unit}.
	 * @param ctx the parse tree
	 */
	void exitTime_unit(TIME_FLOWParser.Time_unitContext ctx);
}