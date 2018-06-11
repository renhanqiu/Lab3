package helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class GraphMetrics {
	static public double degreeCentrality(Graph<Vertex, Edge> g) {
		double centrality = 0;
		for (Vertex v: g.vertices()) {
			centrality += new degreeCentrality().centrality(g, v);
		}
		return centrality;
	}
	
	static public double inDegreeCentrality(Graph<Vertex, Edge> g, Vertex v) {
		double centrality = 0;
		for (Edge edge: g.edges())
			if (edge.targetVertices().contains(v)) centrality++;
		return centrality;
	}
	
	static public double outDegreeCentrality(Graph<Vertex, Edge> g, Vertex v) {
		double centrality = 0;
		for (Edge edge: g.edges())
			if (edge.sourceVertices().contains(v)) centrality++;
		return centrality;
	}
	
	static private Map<Vertex, Double> Distances(Graph<Vertex, Edge> g, Vertex v)	{
		Map<Vertex, Double> distances = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		for (Vertex element: g.vertices()) {
			if (element.equals(v)) {
				queue.add(element);
				distances.put(element, 0.0);
			}
		}
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex target: g.targets(current).keySet()) {
				if(distances.containsKey(target)) continue;
				queue.add(target);
				for (Double weight: g.targets(current).get(target)) {
					if (weight == -1) distances.put(target, distances.get(current) + 1);
					else distances.put(target, distances.get(current) + weight);
				}
			}
		}
		return distances;
	}
	
	static public double distance(Graph<Vertex, Edge> g, Vertex start, Vertex end) {
		boolean judge = false;
		double distance = 0;
		if (start.equals(end)) judge = true;
		for (Vertex vertex: Distances(g, start).keySet()) {
			if (vertex.equals(end)) {
				distance = Distances(g, start).get(end);
				judge = true;
			}
		}
		if (!judge) distance = -1;
		return distance;
	}
	
	static public double eccentricity(Graph<Vertex, Edge> g, Vertex v) {
		double eccentricity = 0;
		for (Vertex vertex: Distances(g, v).keySet()) {
			if (Distances(g, v).get(vertex) > eccentricity) 
				eccentricity = Distances(g, v).get(vertex);
		}
		return eccentricity;
	}
	
	static public double radius(Graph<Vertex, Edge> g) {
		double radius = 1000;
		for (Vertex vertex: g.vertices()) {
			if (eccentricity(g, vertex) < radius)
				radius = eccentricity(g, vertex);
		}
		return radius;
	}
	
	static public double diameter(Graph<Vertex, Edge> g) {
		double diameter = 0;
		for (Vertex vertex: g.vertices()) {
			if (eccentricity(g, vertex) > diameter)
				diameter = eccentricity(g, vertex);
		}
		return diameter;
	}
}
