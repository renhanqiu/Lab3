package edge;

import java.util.Objects;

public class NetworkConnection extends UndirectedEdge{
	private String label;
	private double weight;
	
	public NetworkConnection(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight > 0;
		assert vertices().size() == 2;
		assert sourceVertices().size() == 2;
		assert targetVertices().size() == 2;
	}
	
	@Override
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	NetworkConnection edge = (NetworkConnection) o;
    	return Objects.equals(label, edge.label)
    		&& Objects.equals(weight, edge.weight);
    }
}
