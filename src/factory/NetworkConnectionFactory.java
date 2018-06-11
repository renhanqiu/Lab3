package factory;

import java.util.List;

import edge.Edge;
import edge.NetworkConnection;
import vertex.Vertex;

public class NetworkConnectionFactory extends EdgeFactory {

	@Override
	public Edge createEdge(String type, String label, double weight, List<Vertex> vertices) {
		// TODO Auto-generated method stub
		Edge edge = null;
		if (type.equals("NetworkConnection")) {
			edge = new NetworkConnection(label, weight);
			edge.addVertices(vertices);
		}
		else System.out.println("Illegal type.");
		return edge;
	}

}
