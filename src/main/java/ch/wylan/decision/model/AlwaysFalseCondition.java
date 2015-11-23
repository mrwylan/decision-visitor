package ch.wylan.decision.model;

public class AlwaysFalseCondition<E> extends Condition<E> {

	@Override
	public Boolean execute(E input) {
		return false;
	}

}
