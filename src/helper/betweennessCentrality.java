package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class betweennessCentrality implements StrategyInterface {

	@Override
	public double centrality(Graph<Vertex, Edge> g, Vertex v) {
		// TODO Auto-generated method stub
		double centrality = 0;
    	for (Vertex src: g.vertices()) {
    		for (Vertex dst: g.vertices()) {
    			if (g.targets(src).containsKey(v) && g.sources(dst).containsKey(v)) centrality++;
    		}
    	}
    	return centrality;
	}

}
