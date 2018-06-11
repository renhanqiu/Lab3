package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class degreeCentrality implements StrategyInterface{

	@Override
	public double centrality(Graph<Vertex, Edge> g, Vertex v) {
		// TODO Auto-generated method stub
		double centrality = 0;
		for (Edge edge: g.edges())
			if (edge.containVertex(v)) centrality++;
		return centrality;
	}

}
