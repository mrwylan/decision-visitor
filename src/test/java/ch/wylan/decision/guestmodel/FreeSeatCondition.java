package ch.wylan.decision.guestmodel;

import ch.wylan.decision.model.Condition;
import ch.wylan.decision.model.IConditionVisitor;

public class FreeSeatCondition extends Condition<PartyRegistrationOrder> {
	
	@Override
	public <T> T accept(IConditionVisitor<PartyRegistrationOrder, T> visitor) {
		return visitor.visitCondition(this);
	}

	@Override
	public Boolean execute(PartyRegistrationOrder input) {
		return input.getLocation().getPlacementsCount() < input.getLocation().getSeatsCount();
	}

}
