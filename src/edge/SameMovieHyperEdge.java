package edge;

import java.util.Objects;

public class SameMovieHyperEdge extends HyperEdge {
	private String label;
	private double weight;
	
	public SameMovieHyperEdge(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight == -1;
		assert vertices().size() > 0;
		assert sourceVertices().size() == targetVertices().size();
		assert targetVertices().size() == vertices().size();
	}
	
	@Override public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	SameMovieHyperEdge edge = (SameMovieHyperEdge) o;
    	return Objects.equals(label, edge.label)
            && Objects.equals(weight, edge.weight);
    }
}
