package ch.wylan.decision.model;

import java.util.List;

public class CompositionDecision<E> extends CompositionCondition<E> {

	public CompositionDecision(List<Condition<E>> conditions) {
		super(conditions);
	}

	@Override
	public <T> T accept(IConditionVisitor<E, T> visitor) {
		return visitor.visitCompositionDecision(this);
	}
	
}
