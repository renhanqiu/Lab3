package factory;

import vertex.Actor;
import vertex.Director;
import vertex.Movie;
import vertex.Vertex;

public class MovieVertexFactory extends  VertexFactory{

	@Override
	public Vertex createVertex(String type, String label, String[] args) {
		// TODO Auto-generated method stub
		Vertex movie = null;
		switch (type) {
		case "Movie":
			movie = new Movie(label);
			break;
		case "Actor":
			movie = new Actor(label);
			break;
		case "Director":
			movie = new Director(label);
			break;
		default:
			System.out.println("Illegal type.");
		}
		movie.fillVertexInfo(args);
		return movie;
	}

}
