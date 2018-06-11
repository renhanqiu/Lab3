package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class Centrality {
  private StrategyInterface strategy;

public Centrality(StrategyInterface strategy) {
	this.strategy = strategy;
}
public double getCentrality(Graph<Vertex, Edge> g, Vertex v) {
	return this.strategy.centrality(g, v);
}
}
