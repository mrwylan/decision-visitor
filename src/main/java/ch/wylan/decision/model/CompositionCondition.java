package ch.wylan.decision.model;

import java.util.List;

public abstract class CompositionCondition<E> extends Condition<E> {
	
	protected final List<? extends Condition<E>> conditions;

	public CompositionCondition(List<? extends Condition<E>> conditions) {
		this.conditions = conditions;
	}

	public List<? extends Condition<E>> getConditions() {
		return conditions;
	}
	
	public boolean internalExecute(Condition<E> condition, E input){
		return condition.evaluate(input);
	}
	
}
