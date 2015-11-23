package ch.wylan.decision.model;

public class NoDecision<E> extends Decision<E> {

	
	@Override
	public E execute(E input) {
		return input;
	}
	
}
