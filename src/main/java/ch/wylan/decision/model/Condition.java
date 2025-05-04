package ch.wylan.decision.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Condition<E> {

	public Boolean execute(E input) {
		return false;
	}

	public <T> T accept(IConditionVisitor<E, T> visitor) {
		return visitor.visitCondition(this);
	}

	public Condition<E> and(Condition<E> condition) {
		return new AndCondition<>(Arrays.asList(this, condition));
	}

	public Condition<E> or(Condition<E> condition) {
		return new OrCondition<>(Arrays.asList(this, condition));
	}

	public Condition<E> and(List<? extends Condition<E>> conditions) {
		List<Condition<E>> andConditions = new ArrayList<>();
		andConditions.add(this);
		andConditions.addAll(conditions);
		return new AndCondition<>(andConditions);
	}

	public Condition<E> or(List<? extends Condition<E>> conditions) {
		List<Condition<E>> orConditions = new ArrayList<>();
		orConditions.add(this);
		orConditions.addAll(conditions);
		return new OrCondition<>(orConditions);
	}

	// New feature: Create condition from Predicate
	public static <E> Condition<E> fromPredicate(Predicate<E> predicate) {
		return new Condition<E>() {
			@Override
			public Boolean execute(E input) {
				return predicate.test(input);
			}
		};
	}

	// New feature: Negate a condition
	public Condition<E> not() {
		final Condition<E> original = this;
		return new Condition<E>() {
			@Override
			public Boolean execute(E input) {
				return !original.execute(input);
			}
		};
	}
}