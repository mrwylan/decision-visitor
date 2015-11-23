package ch.wylan.decision.guestmodel;

import ch.wylan.decision.model.Condition;
import ch.wylan.decision.model.IConditionVisitor;

public class VipCondition extends Condition<PartyRegistrationOrder> {

	@Override
	public <T> T accept(IConditionVisitor<PartyRegistrationOrder, T> visitor) {
		return visitor.visitCondition(this);
	}

	@Override
	public Boolean execute(PartyRegistrationOrder input) {
		return input.getRegistrationGuest().isVIP();
	}
}
