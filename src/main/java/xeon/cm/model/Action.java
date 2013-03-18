package xeon.cm.model;

import javax.persistence.Embeddable;

@Embeddable
public class Action {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
