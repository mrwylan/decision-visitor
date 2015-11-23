package ch.wylan.decision.model;

import java.util.List;

public class OrCondition<E> extends CompositionCondition<E> {

	public OrCondition(List<? extends Condition<E>> conditions) {
		super(conditions);
	}

	@Override
	public Boolean execute(E input) {
		for (Condition<E> condition : conditions) {
			if(internalExecute(condition,input)){
				return true;
			}
		}
		return false;
	}

}
