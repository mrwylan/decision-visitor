package ch.wylan.decision.guestmodel;

import java.util.Iterator;

import ch.wylan.decision.model.AlwaysFalseCondition;
import ch.wylan.decision.model.AlwaysTrueCondition;
import ch.wylan.decision.model.AndCondition;
import ch.wylan.decision.model.Condition;
import ch.wylan.decision.model.IConditionVisitor;
import ch.wylan.decision.model.OrCondition;

public class PartyRegistration {

	private PartyRegistrationOrder order;

	public Placement register(PartyRegistrationOrder registrationOrder) {
		order = registrationOrder;

		Condition<PartyRegistrationOrder> registrationConditions = order.getLocation().getRegistrationCondition();

		Placement placement = registrationConditions.accept(this);
		if (placement == null) {
			System.out.println("no placement for " + registrationOrder.getRegistrationGuest().getName());
			
		} else {
			System.out.println("new placement for " + placement.getGuest().getName() + " in "
					+ placement.getLounge().getClass().getSimpleName());
		}
		order.getLocation().getPlacements().add(placement);

		return placement;
	}

	private Placement getPlacementForGuest() {
		return new Placement(order.getRegistrationGuest(), order.getLocation().getLounge());
	}

	@Override
	public Placement visitAlwaysTrueCondition(AlwaysTrueCondition condition) {
		return getPlacementForGuest();
	}

	@Override
	public Placement visitAlwaysFalseCondition(AlwaysFalseCondition condition) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Placement visitOrCondition(OrCondition condition) {
		System.out.println("visitOrCondition " + condition.getClass().getSimpleName());
		Placement placement = null;
		Iterator<Condition<PartyRegistrationOrder>> iterator = condition.getConditions().iterator();
		while (iterator.hasNext() && placement == null) {
			placement = iterator.next().accept(this);
		}
		return placement;
	}

	@Override
	public Placement visitAndCondition(AndCondition condition) {
		System.out.println("visitAndCondition " + condition.getClass().getSimpleName());
		if (condition.evaluate(this.order)) {
			return ((Iterator<Condition<PartyRegistrationOrder>>) condition.getConditions().iterator()).next()
					.accept(this);
		}
		return null;
	}

	@Override
	public Placement visit(Condition condition) {
		System.out.println("visit " + condition.getClass().getSimpleName());
		if (condition.evaluate(this.order)) {
			return getPlacementForGuest();
		}
		return null;
	}

	@Override
	public Placement visitVipCondition(Condition vipCondition) {
		System.out.println("visitVip " + vipCondition.getClass().getSimpleName());
		if (((VipCondition) vipCondition).apply(this.order)) {
			return getVipPlacementForGuest();
		}
		return null;
	}

	private Placement getVipPlacementForGuest() {
		return new Placement(this.order.getRegistrationGuest(), this.order.getLocation().getVipLounge());
	}

}
