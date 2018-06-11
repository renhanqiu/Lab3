package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import vertex.Vertex;

public class HyperEdge extends Edge{
	private Set<Vertex> vertice = new HashSet<>();
	private String label;
	private double weight;
	public HyperEdge(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight == -1;
		assert vertices().size() > 0;
	}
	
	@Override public String getType() {
		return "HyperEdge";
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
	
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		if (vertices.size() == 0) 
			return false;
		else 
			for (Vertex v: vertices) vertice.add(v);
		return true;
	}
	
	@Override
	public Set<Vertex> sourceVertices() {
		return vertice;
	}
	
	@Override
	public Set<Vertex> targetVertices() {
		return vertice;
	}
	
	@Override
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	HyperEdge edge = (HyperEdge) o;
    	return Objects.equals(label, edge.label)
        	&& Objects.equals(weight, edge.weight);
    }
    
    @Override
    public String toString() {
    	checkRep();
		StringBuilder str = new StringBuilder(label + "-" + "vertices { ");
		for (Vertex v: vertices())
			str.append(v.getLabel() + " ");
		str.append("}");
		return str.toString(); 
    }
}
