package ch.wylan.decision.model;

import java.util.List;

public class AndCondition<S> extends CompositionCondition<S> {

	public AndCondition(List<? extends Condition<S>> conditions) {
		super(conditions);
	}

	@Override
	public Boolean execute(S input) {
		for (Condition<S> condition : conditions) {
			if(!internalExecute(condition, input)){
				return false;
			}
		}
		return true;
	}

}
