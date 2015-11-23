package ch.wylan.decision.guestmodel;

import java.util.ArrayList;
import java.util.List;

import ch.wylan.decision.model.Condition;

public class PartyLocation {
	
	private Lounge lounge = new PublicLounge(5);
	private VipLounge vipLounge = new VipLounge(3);
	private List<Placement> placements = new ArrayList<>();
	private Condition<PartyRegistrationOrder> registrationCondition = new VipCondition().and(new FreeVipSeatCondition()).or(new FreeSeatCondition());

	public VipLounge getVipLounge() {
		return vipLounge;
	}
	
	public List<Placement> getPlacements() {
		return placements;
	}

	public Lounge getLounge() {
		return lounge;
	}
	
	public Placement register(Guest guest){
		
		PartyRegistration registration = new PartyRegistration();
		Placement placement = registration.register(new PartyRegistrationOrder(this, guest));
		
		return placement;
	}

	public int getPlacementsCount() {
		return placements.size();
	}

	public int getSeatsCount() {
		return lounge.getSeats();
	}

	public Condition<PartyRegistrationOrder> getRegistrationCondition() {
		return registrationCondition;
	}



	public int getVipPlacementsCount() {
		int count = 0;
		for (Placement placement : placements) {
			if(placement.getLounge().equals(vipLounge)){
				count++;
			}
		}
		return count;
	}
}
