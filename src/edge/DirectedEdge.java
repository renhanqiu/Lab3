package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class DirectedEdge extends Edge {
	private Set<Vertex> vertice = new HashSet<>();
	private String label;
	private double weight;
	private Vertex source, target;
	@Override protected void checkRep() {
		assert label != null;
		assert vertices().size() > 0;
		assert sourceVertices().size() > 0;
		assert targetVertices().size() > 0;
	}
	public DirectedEdge(String label, double weight) {
		super(label,weight);
		this.label = label;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "DirectedEdge [vertice=" + vertice + ", label=" + label + ", weight=" + weight + ", source=" + source
				+ ", target=" + target + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		if (!(obj instanceof DirectedEdge))
			return false;
		DirectedEdge other = (DirectedEdge) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
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
	public Set<Vertex> getVertice() {
		return vertice;
	}
	public void setVertice(Set<Vertex> vertice) {
		this.vertice = vertice;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getTarget() {
		return target;
	}
	public void setTarget(Vertex target) {
		this.target = target;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DirectedEdge";
	}
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		// TODO Auto-generated method stub
		if(vertices.size()>2||vertices.size()<1)	
		return false;
		else {
			if(vertices.size()==2) {
				source=vertices.get(0);
				target=vertices.get(1);
				vertice.add(source);
				vertice.add(target);
			}else {
				source=target=vertices.get(0);
				vertice.add(source);
			}
		}
		return true;
	}
	@Override
	public Set<Vertex> sourceVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> sources=new HashSet<>();
		sources.add(source);
		return sources;
	}
	@Override
	public Set<Vertex> targetVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> targets=new HashSet<>();
		targets.add(target);
		return targets;
	}
	
}
