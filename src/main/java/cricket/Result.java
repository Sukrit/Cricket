package cricket;

import java.util.List;
import java.util.Map;

public class Result {

	Map<String, Double> players;
	String date;
	String city;
	String winner;
	List<String> teams;
	public Map<String, Double> getPlayers() {
		return players;
	}
	public void setPlayers(Map<String, Double> players) {
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
