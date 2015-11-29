package ch.wylan.decision.model;

public abstract class Rule<E> extends Condition<E> {

	protected Condition<E> condition;
	protected Decision<E> decision;
	protected Condition<E> alternative;
	
	public Rule(Condition<E> condition, Decision<E> decision, Condition<E> alternative) {
		this.condition = condition;
		this.decision = decision;
		this.alternative = alternative;
	}
	public Rule(Condition<E> condition, Decision<E> decision) {
		this( condition, decision,new Condition<>());
	}
	
	public Rule(Decision<E> decision){
		this( new TrueCondition<>(), decision,new Condition<>());
	}

	@Override
	public Boolean execute(E input) {
		if(condition.execute(input)){
			return decision.execute(input);
		}
		return alternative.execute(input);
	}

	public Condition<E> getCondition() {
		return condition;
	}

	public Decision<E> getDecision() {
		return decision;
	}

	public Condition<E> getAlternative() {
		return alternative;
	}
}
