package ch.wylan.decision.guestmodel;

import ch.wylan.decision.model.AbstractConditionVisitor;
import ch.wylan.decision.model.Condition;

public class PartyRegistration extends AbstractConditionVisitor<PartyRegistrationOrder, Placement> {

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

}
