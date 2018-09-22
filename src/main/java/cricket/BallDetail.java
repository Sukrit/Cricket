package cricket;

public class BallDetail {
	private String batsman;
	private String bowler;
	private String non_striker;
	private Runs runs;
	private Wicket wicket;
	public String getBatsman() {
		return batsman;
	}
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public String getNon_striker() {
		return non_striker;
	}
	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}
	public Runs getRuns() {
		return runs;
	}
	public void setRuns(Runs runs) {
		this.runs = runs;
	}
	public Wicket getWicket() {
		return wicket;
	}
	public void setWicket(Wicket wicket) {
		this.wicket = wicket;
	}
}

