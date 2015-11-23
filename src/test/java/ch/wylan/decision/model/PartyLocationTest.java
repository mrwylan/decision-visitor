package ch.wylan.decision.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ch.wylan.decision.guestmodel.Guest;
import ch.wylan.decision.guestmodel.PartyLocation;
import ch.wylan.decision.guestmodel.Placement;

public class PartyLocationTest {

	@Test
	public void ShoulRegister() {
		PartyLocation location = new PartyLocation();

		Placement placement = location.register(new Guest("Hansi"));

		assertNotNull(placement);
		assertTrue(placement.isValid());

		List<String> guests = Arrays.asList("Josef", "Fatima", "Mirosch", "Vladimir");
		for (String guest : guests) {
			Placement guestPlacement = location.register(new Guest(guest));
			assertNotNull(guestPlacement);
			assertTrue(guestPlacement.isValid());
		}

		Placement latePlacement = location.register(new Guest("To Late"));
		assertNull(latePlacement);

	}

	@Test
	public void shouldRegisterVipGuest() {
		PartyLocation location = new PartyLocation();

		Guest vipGuest = new Guest("Hansi Vip") {

			@Override
			public boolean isVIP() {
				return true;
			}
		};
		Placement placement = location.register(vipGuest);

		assertNotNull(placement);
		assertTrue(placement.isValid());
		assertEquals(location.getVipLounge(), placement.getLounge() );
		
		for(int i = 0; i <4; i++); {
			Placement registered = location.register(vipGuest);
			
			assertNotNull(registered);
			assertTrue(registered.isValid());
			assertEquals(location.getVipLounge(), registered.getLounge() );
			
		}
		
		Guest vipGuest2 = new Guest("To Late Vip") {
			
			@Override
			public boolean isVIP() {
				return true;
			}
		};
		Placement placement2 = location.register(vipGuest2);
		
		assertNotNull(placement2);
		assertTrue(placement2.isValid());
		assertEquals(location.getLounge(), placement2.getLounge() );
		
	}

}
