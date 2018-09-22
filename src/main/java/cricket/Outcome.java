package cricket;

public class Outcome {
	
	private By by;
	private String winner;
	private String method;
	private String result;
	private String eliminator;
	private String bowl_out;
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

	public By getBy() {
		return by;
	}

	public void setBy(By by) {
		this.by = by;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEliminator() {
		return eliminator;
	}
	public void setEliminator(String eliminator) {
		this.eliminator = eliminator;
	}
	public String getBowl_out() {
		return bowl_out;
	}
	public void setBowl_out(String bowl_out) {
		this.bowl_out = bowl_out;
	}
	

}
