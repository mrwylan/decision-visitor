package ch.wylan.decision.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NoDecisionTest {
	
	@Test
	public void shouldNotChangeInput(){
		final String input = "welcome";
		Decision<String> decision = new Decision<>();
		
		Boolean result = decision.execute(input);
		
		assertFalse(result);
		
		result = decision.also(new Decision<>()).execute(input);
		assertFalse(result);
		
	}

}
