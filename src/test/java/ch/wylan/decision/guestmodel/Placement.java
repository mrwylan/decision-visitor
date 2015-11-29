package ch.wylan.decision.guestmodel;

public class Placement {
	
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

}
