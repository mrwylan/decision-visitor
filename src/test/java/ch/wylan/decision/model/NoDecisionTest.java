package ch.wylan.decision.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NoDecisionTest {
	
	@Test
	public void shouldNotChangeInput(){
		final String input = "welcome";
		Decision<String> decision = new NoDecision<>();
		
		String result = decision.apply(input);
		
		assertEquals(result, "welcome");
		
		result = decision.also(new NoDecision<String>()).apply(input);
		assertEquals(result, "welcome");
		
	}

}
