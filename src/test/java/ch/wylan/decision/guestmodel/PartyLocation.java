package ch.wylan.decision.guestmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import ch.wylan.decision.model.Condition;

public class PartyLocation {

	private final Lounge lounge = new PublicLounge(5);
	private final VipLounge vipLounge = new VipLounge(3);
	private final List<Placement> placements = new ArrayList<>();
	private final Condition<PartyRegistrationOrder> registrationCondition =
			new VipCondition().and(new FreeVipSeatCondition()).or(new FreeSeatCondition());

	public VipLounge getVipLounge() {
		return vipLounge;
	}

	public List<Placement> getPlacements() {
		return placements;
	}

	public Lounge getLounge() {
		return lounge;
	}

	public Placement register(Guest guest) {
		PartyRegistration registration = new PartyRegistration();
		return registration.register(new PartyRegistrationOrder(this, guest));
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
		// Using streams instead of for loop
		return (int) placements.stream()
				.filter(placement -> placement.getLounge().equals(vipLounge))
				.count();
	}

	// New feature: Get placements by lounge type
	public List<Placement> getPlacementsByLoungeType(Class<? extends Lounge> loungeType) {
		return placements.stream()
				.filter(placement -> loungeType.isInstance(placement.getLounge()))
				.collect(Collectors.toList());
	}

	// New feature: Check if guest is already registered
	public boolean isGuestRegistered(Guest guest) {
		return placements.stream()
				.anyMatch(placement -> placement.getGuest().getName().equals(guest.getName()));
	}
}