package ch.wylan.decision.guestmodel;

public class Guest {
	
	public final String name;
	
	public Guest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isVIP(){
		return false;
	}
	
	public boolean isFirstimeVisit(){
		return false;
	}
	
	public boolean isBirthdayVisit(){
		return false;
	}

}
