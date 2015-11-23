package ch.wylan.decision.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Condition<E> extends Step<E, Boolean> {
	
	public <T> T accept(IConditionVisitor<E, T> visitor){
		return visitor.visitCondition(this);
	};

	public boolean evaluate( E input){
		return this.execute(input);
	}
	
	public Condition<E> and (Condition<E> condition){
		return new AndCondition<E>(Arrays.asList(this, condition));
	}
	
	public Condition<E> or (Condition<E> condition){
		return new OrCondition<E>(Arrays.asList(this, condition));
	}
	
	public Condition<E> and (List<? extends Condition<E>> conditions){
		List< Condition<E>> andConditions = new ArrayList<>();
		andConditions.add(this);
		andConditions.addAll(conditions);
		return new AndCondition<E>(andConditions);
	}
	
	public Condition<E> or (List<? extends Condition<E>> conditions){
		List< Condition<E>> orConditions = new ArrayList<>();
		orConditions.add(this);
		orConditions.addAll(conditions);
		return new OrCondition<E>(orConditions);
	}

			
}
