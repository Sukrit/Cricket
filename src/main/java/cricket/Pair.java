package cricket;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair {
	
	@JsonProperty
	private double over;
	
	@JsonProperty
	private BallDetail ballDetail;
	
	public BallDetail getBallDetail() {
		return ballDetail;
	}
	public void setBallDetail(BallDetail ballDetail) {
		this.ballDetail = ballDetail;
	}

	
	@JsonAnyGetter
    public Double getOver() {
        return this.over;
    }

    @JsonAnySetter
    public void setOver(double value) {
        this.over = value;
    }
}
