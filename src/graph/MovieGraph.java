package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edge.Edge;
import vertex.Vertex;

public class MovieGraph extends ConcreteGraph<Vertex, Edge> {
	@Override public String getType() {
		return "MovieGraph";
	}
	
	@Override public Map<Vertex, List<Double>> targets(Vertex source) {
		Map<Vertex, List<Double>> targets = new HashMap<>();
		for (Edge edge: edges()) {
			if (edge.sourceVertices().contains(source))
				for (Vertex target: edge.targetVertices()) {
					if (!target.equals(source)) {
						if (!targets.containsKey(target))
							targets.put(target, new ArrayList<>());
						targets.get(target).add(edge.getWeight());
					}
				}
		}
		return targets;
	}
	
	@Override public boolean legalEdge(String type, String weighted, String directed) {
    		return (type.equals("MovieActorRelation") && weighted.equals("Y") && directed.equals("N")) ||
    			   ((type.equals("SameMovieHyperEdge") || type.equals("MovieDirectorRelation")) && weighted.equals("N") && directed.equals("N"));
    }
	
	@Override public String toString() {
		StringBuilder str = new StringBuilder(getName() + "\n");
		for (Vertex vertex: vertices()) {
			if (vertex.getType().equals("Movie")) {
				str.append("& Movie-" + vertex.toString() + "\n");
				for (Vertex v: targets(vertex).keySet())
					if (v.getType().equals("Director")) str.append(v.toString() + "\n");
				for (Vertex v: targets(vertex).keySet()) {
					if (v.getType().equals("Actor"))
						str.append(v.toString() + "-" + targets(vertex).get(v).get(0) + "\t");
				}
				str.append("\n\n");
			}
		}
		return str.toString();
	}
}
