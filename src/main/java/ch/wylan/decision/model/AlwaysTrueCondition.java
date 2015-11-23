package ch.wylan.decision.model;

public class AlwaysTrueCondition<E> extends Condition<E> {

	@Override
	public Boolean execute(E input) {
		return true;
	}

}
