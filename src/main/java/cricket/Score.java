package cricket;

public class Score {
	
	private Double runs;
	private boolean isOut;
	public Score(Double runs, boolean isOut) {
		// TODO Auto-generated constructor stub
		this.runs = runs;
		this.isOut = isOut;
	}
	public Double getRuns() {
		return runs;
	}
	public void setRuns(Double runs) {
		this.runs = runs;
	}
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

}
