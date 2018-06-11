package edge;

import java.text.DecimalFormat;
import java.util.Objects;

public class FriendConnection extends DirectedEdge {
	private String label;
	private double weight;
	
	public FriendConnection(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight > 0;
		assert vertices().size() == 2;
		assert sourceVertices().size() == 1;
		assert targetVertices().size() == 1;
	}
	
	@Override public String getType() {
		return "FriendTie";
	}
	
	@Override public void setWeight(double Weight) {
		this.weight = Weight;
	}
	
	@Override public double getWeight() {
		return weight;
	}
	
	@Override public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	FriendConnection edge = (FriendConnection) o;
    	return Objects.equals(label, edge.label)
    		&& Objects.equals(weight, edge.weight);
    }
	
	@Override public String toString() {
		checkRep();
		DecimalFormat df = new DecimalFormat("#0.00");   
		return "FriendTie-" + df.format(weight);
	}
}
