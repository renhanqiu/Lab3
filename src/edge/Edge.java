package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public abstract class Edge {
	private Set<Vertex> vertice = new HashSet<>();
	private String label;
	private double weight;
	public Edge(String label, double weight) {
		this.label = label;
		this.weight = weight;
	}
public abstract String getType();
	
	protected void checkRep() {
		assert label != null;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setWeight(double Weight) {
		this.weight = Weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	abstract public boolean addVertices(List<Vertex> vertices);
	public boolean containVertex(Vertex v)//该边中是否包含指定的点V
	{
		return vertice.contains(v);
	}
	public Set<Vertex> vertices(){   //边包含的点集
		vertice.addAll(sourceVertices());
		vertice.addAll(targetVertices());
		return vertice;
		
	}
	public abstract Set<Vertex> sourceVertices();
	public abstract Set<Vertex> targetVertices();

	@Override
	public String toString() {
		return "Edge [vertice=" + vertice + ", label=" + label + ", weight=" + weight + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (vertice == null) {
			if (other.vertice != null)
				return false;
		} else if (!vertice.equals(other.vertice))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
