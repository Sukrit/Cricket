package cricket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cricsheet {
	
	private Meta meta;
	private Info info;
	private List<Inning> innings;
	
	
	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Inning> getInnings() {
		return innings;
	}

	public void setInnings(List<Inning> innings) {
		this.innings = innings;
	}
	

}
