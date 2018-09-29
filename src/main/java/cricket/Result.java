package cricket;

import java.util.List;
import java.util.Map;

public class Result {

	Map<String, Score> players;
	String date;
	String city;
	String winner;
	List<String> teams;
	String id;
	Double secondScore;
	public Double getSecondScore() {
		return secondScore;
	}
	public void setSecondScore(Double secondScore) {
		this.secondScore = secondScore;
	}
	public boolean isSecondWon() {
		return secondWon;
	}
	public void setSecondWon(boolean secondWon) {
		this.secondWon = secondWon;
	}
	boolean secondWon;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Score> getPlayers() {
		return players;
	}
	public void setPlayers(Map<String, Score> players) {
		this.players = players;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public List<String> getTeams() {
		return teams;
	}
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
	
}
