package ch.wylan.decision.model;

import java.util.List;

public class AnyCondition<E> extends CompositionCondition<E> {

	public AnyCondition(List<? extends Condition<E>> conditions) {
		super(conditions);
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
