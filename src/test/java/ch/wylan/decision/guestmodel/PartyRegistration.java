package ch.wylan.decision.guestmodel;

import ch.wylan.decision.model.*;
import java.util.logging.Logger;

public class PartyRegistration extends AbstractConditionVisitor<PartyRegistrationOrder, Placement> {

	private static final Logger LOGGER = Logger.getLogger(PartyRegistration.class.getName());
	private PartyRegistrationOrder order;

	public Placement register(PartyRegistrationOrder registrationOrder) {
		order = registrationOrder;
		Condition<PartyRegistrationOrder> registrationConditions = order.getLocation().getRegistrationCondition();

		// Execute the visitor pattern
		Placement placement = registrationConditions.accept(this);

		if (placement == null) {
			LOGGER.info(() -> "No placement for " + registrationOrder.getRegistrationGuest().getName());
			return null;
		} else {
			LOGGER.info(() -> "New placement for " + placement.getGuest().getName() +
					" in " + placement.getLounge().getClass().getSimpleName());
			order.getLocation().getPlacements().add(placement);
			return placement;
		}
	}

	@Override
	public Placement visitCondition(Condition<PartyRegistrationOrder> condition) {
		if (condition.execute(order)) {
			return getPlacementForGuest();
		}
		return null;
	}

	@Override
	public Placement visitAndCondition(AndCondition<PartyRegistrationOrder> andCondition) {
		// If all conditions are true, use the first successful placement strategy
		if (andCondition.execute(order)) {
			for (Condition<PartyRegistrationOrder> condition : andCondition.getConditions()) {
				Placement placement = condition.accept(this);
				if (placement != null) {
					return placement;
				}
			}
		}
		return null;
	}

	@Override
	public Placement visitOrCondition(OrCondition<PartyRegistrationOrder> orCondition) {
		// Try each condition in order
		for (Condition<PartyRegistrationOrder> condition : orCondition.getConditions()) {
			if (condition.execute(order)) {
				Placement placement = condition.accept(this);
				if (placement != null) {
					return placement;
				}
			}
		}
		return null;
	}

	private Placement getPlacementForGuest() {
		Lounge lounge = order.getRegistrationGuest().isVIP()?order.getLocation().getVipLounge() : order.getLocation().getLounge();
		return new Placement(order.getRegistrationGuest(), lounge);
	}
}