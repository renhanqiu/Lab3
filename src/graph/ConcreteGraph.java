package graph;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import edge.Edge;
import vertex.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ConcreteGraph <L,E> implements Graph<Vertex,Edge>{
	private Set<Vertex> vertice=new HashSet<>();
	private Set<Edge>   edges=new HashSet<>();
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "ConcreteGraph";
	}
	@Override
	public boolean addVertex(Vertex v) {
		// TODO Auto-generated method stub
		if(!vertice.contains(v)) {
			vertice.add(v);
			return true;
		}
		System.out.println("该点已经存在了");
		return false;
	}
	@Override
	public boolean removeVertex(Vertex v) {
		// TODO Auto-generated method stub
		if (!vertice.contains(v)) {
			System.out.println("This vertex doesn't exist.");
			return false;
		}
		vertice.remove(v);
		edges.removeIf(edge -> edge.containVertex(v));
		return true;
		
		
	}
	@Override
	public Set<Vertex> vertices() {
		// TODO Auto-generated method stub
		
		return vertice;
	}
	@Override
	public Map<Vertex, List<Double>> sources(Vertex target) {
		Map<Vertex,List<Double>> sources=new HashMap<>();
		for(Edge edge:edges) {
			if(edge.targetVertices().contains(target)) {
				for(Vertex source:edge.sourceVertices()) {
					if(!sources.containsKey(source))
						sources.put(source, new ArrayList<>());
					sources.get(source).add(edge.getWeight());
				}
			}
		}
        return sources;
	}
	@Override
	public Map<Vertex, List<Double>> targets(Vertex source) {
		// TODO Auto-generated method stub
		Map<Vertex,List<Double>> targets=new HashMap<>();
		for(Edge edge:edges) {
			if(edge.sourceVertices().contains(source)) {
				for(Vertex target:edge.targetVertices()) {
					if(!targets.containsValue(target))
						targets.put(target, new ArrayList<>());
					targets.get(target).add(edge.getWeight());
				}
			}
		}
		return targets;
	}
	@Override
	public boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		if (edges.contains(edge)) {
			System.out.println("This edge has existed.");
			return false;
		}
		edges.add(edge);
		return true;
	}
	@Override
	public boolean removeEdge(Edge edge) {
		// TODO Auto-generated method stub
		if (!edges.contains(edge)) {
			System.out.println("This edge doesn't exist.");
			return false;
		}
		edges.remove(edge); return true;
	}
	@Override
	public Set<Edge> edges() {
		// TODO Auto-generated method stub
		return edges;
	}

	public boolean legalEdge(String type, String weighted, String directed) {
		return true;
	}
}
