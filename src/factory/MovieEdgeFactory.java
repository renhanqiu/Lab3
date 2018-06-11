package factory;

import java.util.List;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.SameMovieHyperEdge;
import vertex.Vertex;

public class MovieEdgeFactory extends EdgeFactory {

	@Override
	public Edge createEdge(String type, String label, double weight, List<Vertex> vertices) {
		// TODO Auto-generated method stub
		Edge movie = null;
		switch (type) {
		case "MovieActorRelation":
			movie = new MovieActorRelation(label, weight);
			break;
		case "MovieDirectorRelation":
			movie = new MovieDirectorRelation(label, weight);
			break;
		case "SameMovieHyperEdge":
			movie = new SameMovieHyperEdge(label, weight);
			break;
		default:
			System.out.println("Illegal type.");
		}
		movie.addVertices(vertices);
		return movie;
	}

}
