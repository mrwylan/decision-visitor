package ch.wylan.decision.model;

import java.util.Arrays;

public class Decision<E> extends Condition<E> {

	public CompositionDecision<E> also(Condition<E> decision){
		return new CompositionDecision<E>(Arrays.asList(this, decision));
	}
	
	public <T> T accept(IConditionVisitor<E, T> visitor){
		return visitor.visitDecision(this);
	}

	@Override
	public Boolean execute(E input) {
		return false;
	};
	
}
