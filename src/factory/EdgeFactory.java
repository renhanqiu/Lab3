package factory;

import java.util.List;

import edge.Edge;
import vertex.Vertex;

public abstract class EdgeFactory {
	abstract public Edge createEdge (String type, String label, double weight, List<Vertex> vertices);
}
