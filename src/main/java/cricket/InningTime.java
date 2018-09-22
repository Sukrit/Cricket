package cricket;

import com.fasterxml.jackson.annotation.JsonProperty;
 
public class InningTime {
	
	@JsonProperty("1st innings")
	private Inning firstInning;
	
	public Inning getFirstInning() {
		return firstInning;
	}

	public void setFirstInning(Inning firstInning) {
		this.firstInning = firstInning;
	}

	public Inning getSecondInning() {
		return secondInning;
	}

	public void setSecondInning(Inning secondInning) {
		this.secondInning = secondInning;
	}

	@JsonProperty("2nd innings")
	private Inning secondInning;
	
}
