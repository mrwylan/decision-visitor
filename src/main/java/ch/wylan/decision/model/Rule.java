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
		this( condition, decision,new AlwaysFalseCondition<>());
	}
	
	public Rule(Decision<E> decision){
		this( new AlwaysTrueCondition<>(), decision,new AlwaysFalseCondition<>());
	}

	@Override
	public Boolean execute(E input) {
		if(condition.evaluate(input)){
			decision.apply(input);
			return true;
		}
		return alternative.evaluate(input);
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
