package cricket;

import java.util.List;

public class Delivery {

	private Integer over;
	private Integer ball;
	private Replacement replacements;
	public Integer getOver() {
		return over;
	}
	public void setOver(Integer over) {
		this.over = over;
	}
	public Integer getBall() {
		return ball;
	}
	public void setBall(Integer ball) {
		this.ball = ball;
	}
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
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
	public List<Wicket> getWickets() {
		return wickets;
	}
	public void setWickets(List<Wicket> wickets) {
		this.wickets = wickets;
	}
	public Replacement getReplacements() {
		return replacements;
	}
	public void setReplacements(Replacement replacements) {
		this.replacements = replacements;
	}
	private String batsman;
	private String bowler;
	private String non_striker;
	private Runs runs;
	private Wicket wicket;
	private Extras extras;
	private List<Wicket> wickets;
	
}
