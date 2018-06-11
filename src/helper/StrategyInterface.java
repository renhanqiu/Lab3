package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public interface StrategyInterface {
	public double centrality(Graph<Vertex, Edge> g, Vertex v);
}
