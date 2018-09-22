package cricket;

import java.util.List;

public class Wicket {
	private List<String> fielders;
	private String kind;
	private String player_out;
	public List<String> getFielders() {
		return fielders;
	}
	public void setFielders(List<String> fielders) {
		this.fielders = fielders;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPlayer_out() {
		return player_out;
	}
	public void setPlayer_out(String player_out) {
		this.player_out = player_out;
	}
}
