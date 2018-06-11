package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edge.Edge;
import vertex.Vertex;

public class GraphPeot extends ConcreteGraph<Vertex, Edge>{
	@Override public String getType() {
		return "GraphPoet";
	}
	
	@Override public boolean addVertex(Vertex v) {
        if (vertices().contains(v)) {
        	System.out.println("This vertex has existed.");
        	return false;
        }
        vertices().add(v); return true;
	}
	/** 
     * Find the bridge.
     * 
     * @param source is the first vertex
     * @param target is the second vertex
     * @return bridge is the vertex which has the max-weight
     */
    public String findBridge(String source, String target) {
    	String bridge = " ";
    	double length = 0;
    	Vertex src = null, tar = null;
    	for (Vertex vertex: vertices()) {
    		if (vertex.getLabel().equalsIgnoreCase(source)) src = vertex;
    		if (vertex.getLabel().equalsIgnoreCase(target)) tar = vertex;
    	}
    	Map<String, Double> bridges = new HashMap<>();
    	for (Vertex vertex: vertices()) {
    		if (targets(src).containsKey(vertex) && sources(tar).containsKey(vertex))
    			bridges.put(vertex.getLabel(), targets(src).get(vertex).get(0) + sources(tar).get(vertex).get(0));
    	}
    	for (String key: bridges.keySet()) {
    		if (bridges.get(key) > length) {
    			length = bridges.get(key);
    			bridge = " " + key + " ";
    		}
    	}
    	return bridge.toLowerCase();
    }
    
    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
        String source;
        String target;
        StringBuilder poem = new StringBuilder("");
        List<String> words = Arrays.asList(input.split(" |\n"));
        for (int i = 0; i < words.size() - 1; i++) {
        	source = words.get(i);
        	target = words.get(i + 1);
        	poem.append(source + findBridge(source, target));
        }
        return poem.toString() + words.get(words.size() - 1);
    }
    
    @Override public boolean legalEdge(String type, String weighted, String directed) {
    	return type.equals("WordNeighborhood") && weighted.equals("Y") && directed.equals("Y");
    }
    
	@Override public String toString() {
		StringBuilder str = new StringBuilder(getName() + "\n");
		for (Vertex vertex: vertices()) {
			str.append("Vertex: " + vertex.getLabel() + "\tLinked: ");
			for (Vertex linked: targets(vertex).keySet())
				str.append(linked.getLabel() + "-" + targets(vertex).get(linked).get(0) + "\t");
			str.append("\n");
		}
		return str.toString();
	}
}
