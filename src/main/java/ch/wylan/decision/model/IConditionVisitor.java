package ch.wylan.decision.model;

public interface IConditionVisitor<E,T> {
	
	T visitStep(Step<E, ?> step);
	
	T visitCondition(Condition<E> condition);
	
	T visitDecision(Decision<E> decision);
	
	T visitRule(Rule<E> rule);

}
