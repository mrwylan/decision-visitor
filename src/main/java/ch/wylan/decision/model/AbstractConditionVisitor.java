package ch.wylan.decision.model;

public abstract class AbstractConditionVisitor<E, T> implements IConditionVisitor<E, T> {

	@Override
	public T visitCondition(Condition<E> condition) {
		return null;
	}

	@Override
	public T visitDecision(Decision<E> decision) {
		return this.visitCondition(decision);
	}

	@Override
	public T visitRule(Rule<E> rule) {
		return this.visitCondition(rule);
	}

	@Override
	public T visitAndCondition(AndCondition<E> andCondition) {
		return this.visitCondition(andCondition);
	}

	@Override
	public T visitCompositionDecision(CompositionDecision<E> compositionDecision) {
		return this.visitCondition(compositionDecision);
	}

	@Override
	public T visitOrCondition(OrCondition<E> orCondition) {
		return this.visitCondition(orCondition);
	}

}
