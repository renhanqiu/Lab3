package vertex;

public abstract class Vertex {
private String label;
private double weight;
public Vertex(String label) {
	this.label = label;
}
public String getType() {
	return "Vertex";
}
public abstract void fillVertexInfo(String[] args);
public String getLabel() {
	return label;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public void setLabel(String label) {
	this.label = label;
}
@Override
public String toString() {
	return "Vertex [label=" + label + ", weight=" + weight + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((label == null) ? 0 : label.hashCode());
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
	Vertex other = (Vertex) obj;
	if (label == null) {
		if (other.label != null)
			return false;
	} else if (!label.equals(other.label))
		return false;
	if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
		return false;
	return true;
}


























}