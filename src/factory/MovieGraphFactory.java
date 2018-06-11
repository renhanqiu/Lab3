package factory;

import edge.Edge;
import graph.Graph;
import graph.MovieGraph;
import vertex.Vertex;

public class MovieGraphFactory extends GraphFactory {

	@Override
	public Graph<Vertex, Edge> createGraph(String filePath) {
		// TODO Auto-generated method stub
		ConcreteGraphFactory factory = new ConcreteGraphFactory (new MovieGraph(), new MovieGraphFactory());
		
		return factory.createGraph(filePath);
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return new MovieEdgeFactory();
	}

	@Override
	public VertexFactory getVertexFactory() {
		// TODO Auto-generated method stub
		return new MovieVertexFactory();
	}

}
