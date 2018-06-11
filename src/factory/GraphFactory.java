package factory;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public abstract class GraphFactory {
abstract public Graph<Vertex, Edge> createGraph(String filePath);
	
	abstract public EdgeFactory getEdgeFactory();
	
	abstract public VertexFactory getVertexFactory();
}
