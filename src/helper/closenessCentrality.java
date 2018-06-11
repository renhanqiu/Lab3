package helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class closenessCentrality implements StrategyInterface  {

	@Override
	public double centrality(Graph<Vertex, Edge> g, Vertex v) {
		// TODO Auto-generated method stub
		double centrality = 0;
		int sum = 0;
		Map<Vertex, Integer> distances = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		for (Vertex element: g.vertices()) {
			if (element.equals(v)) {
				queue.add(element);
				distances.put(element, 0);
			}
		}
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex target: g.targets(current).keySet()) {
				if(distances.containsKey(target)) continue;
				queue.add(target);
				distances.put(target, distances.get(current) + 1);
			}
		}
		for (Vertex vertex: distances.keySet())
			sum += distances.get(vertex);
		centrality = (double) sum / new degreeCentrality().centrality(g, v);
		return centrality;
	}

}
