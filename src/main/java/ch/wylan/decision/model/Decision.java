package ch.wylan.decision.model;

import java.util.Arrays;

public abstract class Decision<E> extends Step<E, E> {

	public E apply(E input) {
		return input;
	}
	
	public Decision<E> also(Decision<E> decision){
		return new CompositionDecision<>(Arrays.asList(this, decision));
	}
	
}
