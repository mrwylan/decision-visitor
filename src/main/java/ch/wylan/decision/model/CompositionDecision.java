package ch.wylan.decision.model;

import java.util.List;

public class CompositionDecision<E> extends Decision<E> {
	
	protected final List<? extends Decision<E>> decisions;

	public CompositionDecision(List<? extends Decision<E>> decisions) {
		this.decisions = decisions;
	}

	public List<? extends Decision<E>> getDecisions() {
		return decisions;
	}

	@Override
	public E execute(E input) {
		for (Decision<E> decision : decisions) {
			input = internalExecute(decision, input);
		}
		return input;
	}
	
	public E internalExecute(Decision<E> decision, E input){
		return decision.apply(input);
	}
	
}
