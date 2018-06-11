package factory;

import java.util.List;

import edge.Edge;
import edge.WordEdge;
import vertex.Vertex;

public class WordNeighborhoodFactory extends EdgeFactory {
	public Edge createEdge (String type, String label, double weight, List<Vertex> vertices) {	
		Edge edge = null;
		if (type.equals("WordNeighborhood")) {
			edge = new WordEdge(label, weight);
			edge.addVertices(vertices);
		}
		else System.out.println("Illegal type.");
		return edge;
	}
}
