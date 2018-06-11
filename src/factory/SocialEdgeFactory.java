package factory;

import java.util.List;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import vertex.Vertex;

public class SocialEdgeFactory extends EdgeFactory {

	@Override
	public Edge createEdge(String type, String label, double weight, List<Vertex> vertices) {
		// TODO Auto-generated method stub
		Edge social = null;
		switch (type) {
		case "FriendTie":
			social = new FriendConnection(label, weight);
			break;
		case "CommentTie":
			social = new CommentConnection(label, weight);
			break;
		case "ForwardTie":
			social = new ForwardConnection(label, weight);
			break;
		default:
			System.out.println("Illegal type.");
		}
		social.addVertices(vertices);
		return social;
	}

}
