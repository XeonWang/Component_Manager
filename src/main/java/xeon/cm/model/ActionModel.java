package xeon.cm.model;

public class ActionModel {
	private String id;
	private int count = 0;
	private int amount;
	
	public ActionModel() {
		
	}
	
	public ActionModel(String id, int amount) {
		this.id = id;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return id + "(" + amount + ") : " + count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}
}
