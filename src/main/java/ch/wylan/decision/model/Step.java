package ch.wylan.decision.model;

public abstract class Step<E, V> {
	
	public abstract V execute(E input);
	
}
