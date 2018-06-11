package edge;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import vertex.Vertex;

public class WordEdge extends DirectedEdge{
	private String label;
	private double weight;
	
	public WordEdge(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight > 0;
		assert vertices().size() > 0;
		assert sourceVertices().size() > 0;
		assert targetVertices().size() > 0;
	}
	
	@Override public String getType() {
		return "WordNeiborhood";
	}
	
	@Override
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	WordEdge edge = (WordEdge) o;
    	return Objects.equals(label, edge.label)
    		&& Objects.equals(weight, edge.weight);
    }


}
