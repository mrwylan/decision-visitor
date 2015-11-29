package ch.wylan.decision.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class NoDecisionTest {
	
	@Test
	public void shouldNotChangeInput(){
		final String input = "welcome";
		Decision<String> decision = new Decision<>();
		
		Boolean result = decision.execute(input);
		
		assertFalse(result);
		
		result = decision.also(new Decision<String>()).execute(input);
		assertFalse(result);
		
	}

}
