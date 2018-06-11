package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import vertex.Vertex;

public class UndirectedEdge extends Edge {
	private Set<Vertex> vertice = new HashSet<>();
	private String label;
	private double weight;
	private Vertex source, target;
	
	public UndirectedEdge(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert vertices().size() == 2;
		assert sourceVertices().size() == 2;
		assert targetVertices().size() == 2;
	}
	
	@Override public String getType() {
		return "UnDirectedEdge";
	}
	
	@Override public void setLabel(String label) {
		this.label = label;
	}
	
	@Override public String getLabel() {
		return label;
	}
	
	@Override public void setWeight(double Weight) {
		this.weight = Weight;
	}
	
	@Override public double getWeight() {
		return weight;
	}
	
	@Override public boolean addVertices(List<Vertex> vertices) {
		if (vertices.size() > 2 || vertices.size() < 1) 
			return false;
		else if (vertices.size() == 2) { 
			source = vertices.get(0);
			target = vertices.get(1);
			vertice.add(source);
			vertice.add(target);
		}
		else {
			source = target = vertices.get(0);
			vertice.add(source);
		}
		return true;
	}
	
	@Override public Set<Vertex> sourceVertices() {
		return vertice;
	}
	
	@Override public Set<Vertex> targetVertices() {
		return vertice;
	}
	
	@Override public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	UndirectedEdge edge = (UndirectedEdge) o;
    	return Objects.equals(label, edge.label)
        	&& Objects.equals(weight, edge.weight);
    }
    
    @Override public String toString() {
    	checkRep();
    	return label + "-" + weight + ": " + source + " - " + target; 
    }
}
