package cricket;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Inning {

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}


	public Integer getInningsNumber() {
		return inningsNumber;
	}
	public void setInningsNumber(Integer inningsNumber) {
		this.inningsNumber = inningsNumber;
	}



	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}



	public Penalty getPenalty_runs() {
		return penalty_runs;
	}
	public void setPenalty_runs(Penalty penalty_runs) {
		this.penalty_runs = penalty_runs;
	}



	private String team;
	private Integer inningsNumber;
	private List<Delivery> deliveries;
	private Penalty penalty_runs;
}
