package ch.wylan.decision.model;

import java.util.List;

public abstract class CompositionCondition<E> extends Condition<E> {
	
	protected final List<Condition<E>> conditions;

	public CompositionCondition(List<Condition<E>> conditions) {
		this.conditions = conditions;
	}

	public List<Condition<E>> getConditions() {
		return conditions;
	}
	
	public boolean internalExecute(Condition<E> condition, E input){
		return condition.execute(input);
	}
	
	@Override
	public Boolean execute(E input) {
		boolean anyApplied = false;
		for (Condition<E> condition : conditions) {
			anyApplied |= internalExecute(condition,input);
		}
		return anyApplied;
	}
	
}
