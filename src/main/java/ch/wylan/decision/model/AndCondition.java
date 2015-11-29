package ch.wylan.decision.model;

import java.util.List;

public class AndCondition<E> extends CompositionCondition<E> {

	@Override
	public <T> T accept(IConditionVisitor<E, T> visitor) {
		return visitor.visitAndCondition(this);
	}

	public AndCondition(List<Condition<E>> conditions) {
		super(conditions);
	}

	@Override
	public Boolean execute(E input) {
		for (Condition<E> condition : conditions) {
			if(!internalExecute(condition, input)){
				return false;
			}
		}
		return true;
	}

}
