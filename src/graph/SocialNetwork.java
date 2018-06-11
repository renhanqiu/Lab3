package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edge.Edge;
import vertex.Vertex;

public class SocialNetwork extends ConcreteGraph<Vertex, Edge> {
	@Override public String getType() {
		return "SocialNetwork";
	}
	
	 protected void checkRep() {
		for (Vertex src: vertices()) {
			for (Vertex dst: vertices()) {
				int i = 0;
				for (Edge edge: edges())
					if (edge.sourceVertices().contains(src) && edge.targetVertices().contains(dst)) i++;
				assert i <= 6;
			}
		}
	}
	
	@Override public boolean removeVertex(Vertex v) {
		if (!vertices().contains(v)) {
			System.out.println("This vertex doesn't exist.");
			return false;
		}
		edges().removeIf(edge -> edge.containVertex(v));    //删除有点的边 
		vertices().remove(v);
		setWeights();   //设置权重
		return true;
	}
	
	
	@Override public boolean removeEdge(Edge edge) {
		if (!edges().contains(edge)) {
			System.out.println("This edge doesn't exist.");
			return false; 
		}
		edges().remove(edge);
		setWeights();
		return true;
	}
	
	public boolean addNewEdge(Edge edge) {
		if (edges().contains(edge)) {
			System.out.println("This edge has existed.");
			return false;
		}
		for (Edge e: edges())
			e.setWeight(e.getWeight() * (1 - edge.getWeight()));
		edges().add(edge);
		return true;
	}
	
	public boolean ChangeEdgeWeight(String label, double weight) {
		boolean exist = false;
		double w = 0;
		for (Edge e: edges()) {
			if (e.getLabel().equals(label)) {
				w = e.getWeight();
				e.setWeight(weight);
				exist = true;
			}
		}
		double sum = (1 - weight) / (1 - w);
		if (!exist) {
			System.out.println("This edge doesn't exist.");
			return false;
		}
		else {
			for (Edge e: edges())
				if (!e.getLabel().equals(label)) e.setWeight(e.getWeight() * sum);
		}
		return true;
	}
	
	public boolean setWeights() {
		double sum = 0;
		for (Edge e: edges()) sum += e.getWeight();
		for (Edge e: edges()) e.setWeight(e.getWeight() / sum);
		return true;
	}
	
	public int getDistance(Vertex src, Vertex dst) {
		Map<Vertex, Integer> distances = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		if (src.equals(dst)) //鍒拌嚜韬窛绂讳负0
			return 0;
		else {
			for (Vertex vertex: vertices()) {
				if (vertex.equals(src)) {
					queue.add(vertex);
					distances.put(vertex, 0);
				}
			}
			while (!queue.isEmpty()) {
				Vertex current = queue.poll();
				for (Vertex target: targets(current).keySet()) {
					if(distances.containsKey(target)) continue;
					queue.add(target);
					distances.put(target, distances.get(current) + 1);
					if (target.equals(dst))
						return distances.get(target);
				}
			}
		}
		return -1;	
	}
	
	@Override public boolean legalEdge(String type, String weighted, String directed) {
		return (type.equals("FriendTie") || type.equals("CommentTie") || type.equals("ForwardTie"))
			&& weighted.equals("Y") && directed.equals("Y");
    }
	
	@Override public String toString() {
		StringBuilder str = new StringBuilder(getName() + "\n");
		for (Vertex vertex: vertices()) {
			str.append("Vertex: " + vertex.toString() + "\tLinked: ");
			for (Edge e: edges()) {
				if (e.sourceVertices().contains(vertex))
					for (Vertex target: e.targetVertices())
						str.append(target.getLabel() + "-" + e.toString() + "\t");
			}
			str.append("\n");
		}
		return str.toString();
	}
}
