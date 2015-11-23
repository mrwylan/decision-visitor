package ch.wylan.decision.guestmodel;

public class PartyRegistrationOrder {
	
	private PartyLocation location;
	private Guest registrationGuest;
	
	public PartyRegistrationOrder(PartyLocation location, Guest registrationGuest) {
		this.location = location;
		this.registrationGuest = registrationGuest;
	}
	public PartyLocation getLocation() {
		return location;
	}
	public void setLocation(PartyLocation location) {
		this.location = location;
	}
	public Guest getRegistrationGuest() {
		return registrationGuest;
	}
	public void setRegistrationGuest(Guest registrationGuest) {
		this.registrationGuest = registrationGuest;
	}
	
}
