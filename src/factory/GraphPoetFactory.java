package factory;

import edge.Edge;
import graph.Graph;
import graph.GraphPeot;
import vertex.Vertex;

public class GraphPoetFactory extends GraphFactory {
	@Override public Graph<Vertex, Edge> createGraph(String filePath) {
		ConcreteGraphFactory factory = new ConcreteGraphFactory (new GraphPeot(), new GraphPoetFactory());
		return factory.createGraph(filePath);
	}
	
	@Override public EdgeFactory getEdgeFactory() {
		return new WordNeighborhoodFactory();
	}
	
	@Override public VertexFactory getVertexFactory() {
		return new WordVertexFactory();
	}
}
