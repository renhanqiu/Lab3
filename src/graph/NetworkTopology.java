package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edge.Edge;
import vertex.Vertex;

public class NetworkTopology extends ConcreteGraph<Vertex, Edge> {
	@Override public String getType() {
		return "NetworkTopology";
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
    	return type.equals("NetworkConnection") && weighted.equals("Y") && directed.equals("N");
    }
	
	@Override public String toString() {
		StringBuilder str = new StringBuilder(getName() + "\n");
		for (Vertex vertex: vertices()) {
			str.append("Vertex: " + vertex.toString() + "\tLinked: ");
			for (Vertex linked: targets(vertex).keySet())
//				if (!linked.equals(vertex))
					str.append(linked.toString() + "-" + targets(vertex).get(linked).get(0) + "\t");
			str.append("\n");
		}
		return str.toString();
	}
}
