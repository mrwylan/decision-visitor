package ch.wylan.decision.model;

public interface IConditionVisitor<E,T> {

	T visitCondition(Condition<E> condition);

	T visitDecision(Decision<E> decision);

	T visitRule(Rule<E> rule);

	T visitAndCondition(AndCondition<E> andCondition);

	T visitCompositionDecision(CompositionDecision<E> compositionDecision);

	T visitOrCondition(OrCondition<E> orCondition);

}