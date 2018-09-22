package cricket;

import java.util.List;
import java.util.Map;

public class Info {
	
	private String city;
	private List<String> dates;
	private String gender;
	private String match_type;
	private Outcome outcome;
	private Integer neutral_venue;
	private String competition;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getDates() {
		return dates;
	}
	public void setDates(List<String> dates) {
		this.dates = dates;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMatch_type() {
		return match_type;
	}
	public void setMatch_type(String match_type) {
		this.match_type = match_type;
	}
	public Outcome getOutcome() {
		return outcome;
	}
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public List<String> getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(List<String> player_of_match) {
		this.player_of_match = player_of_match;
	}
	
	/*
	public Map<String, String> getSupersubs() {
		return supersubs;
	}
	public void setSupersubs(Map<String, String> supersubs) {
		this.supersubs = supersubs;
	}
	*/
	public List<String> getTeams() {
		return teams;
	}
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
	public Toss getToss() {
		return toss;
	}
	public void setToss(Toss toss) {
		this.toss = toss;
	}
	public List<String> getUmpires() {
		return umpires;
	}
	public void setUmpires(List<String> umpires) {
		this.umpires = umpires;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public InningTime getInnings() {
		return innings;
	}
	public void setInnings(InningTime innings) {
		this.innings = innings;
	}
	
	public Integer getNeutral_venue() {
		return neutral_venue;
	}
	public void setNeutral_venue(Integer neutral_venue) {
		this.neutral_venue = neutral_venue;
	}

	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public List<Supersub> getSupersubs() {
		return supersubs;
	}
	public void setSupersubs(List<Supersub> supersubs) {
		this.supersubs = supersubs;
	}

	public List<BowlOut> getBowl_out() {
		return bowl_out;
	}
	public void setBowl_out(List<BowlOut> bowl_out) {
		this.bowl_out = bowl_out;
	}

	private int overs;
	private List<String> player_of_match;
	private List<Supersub> supersubs;
	//private Map<String, String> supersubs;
	private List<String> teams;
	private Toss toss;
	private List<String> umpires;
	private String venue;
	private InningTime innings;
	private List<BowlOut> bowl_out;

}
