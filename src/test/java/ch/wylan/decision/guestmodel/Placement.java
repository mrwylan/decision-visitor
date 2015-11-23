package ch.wylan.decision.guestmodel;

import ch.wylan.decision.model.Decision;

public class Placement extends Decision<PartyRegistrationOrder> {
	
	private final Guest guest;
	private final Lounge lounge;

	public Placement(Guest guest, Lounge lounge) {
		this.guest = guest;
		this.lounge = lounge;
	}

	public Guest getGuest() {
		return guest;
	}

	public Lounge getLounge() {
		return lounge;
	}

	public boolean isValid() {
		return guest !=null && lounge != null;
	}

	@Override
	public PartyRegistrationOrder execute(PartyRegistrationOrder input) {
		// TODO Auto-generated method stub
		return null;
	}

}
