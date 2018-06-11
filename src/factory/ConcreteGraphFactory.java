package factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class ConcreteGraphFactory extends GraphFactory{
      Graph<Vertex,Edge> graph;
      GraphFactory graphFactory;
  	  EdgeFactory edgeFactory;
      VertexFactory vertexFactory;
  	
	
	
	public ConcreteGraphFactory( Graph<Vertex, Edge> graph, GraphFactory graphFactory) {
		this.graph=graph;
		this.graphFactory = graphFactory;
		this.edgeFactory = this.getEdgeFactory();
		this.vertexFactory = this.getVertexFactory();
	}

	@Override
	public Graph<Vertex, Edge> createGraph(String filePath) {
		// TODO Auto-generated method stub
		List<List<String>> Parts = new ArrayList<>();
		String vertexName = null, edgeName = null;
        String vertexType = null, edgeType = null;
		double weight = 0;
		String line = null;
		String[] data;
        StringBuilder text = new StringBuilder("");
        StringBuilder Args = new StringBuilder("");
		try {
			File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
            	if (line.equals("")) text.append("###" + "\n");
            	else text.append(line + "\n");
            }
            br.close();
		} catch (Exception e) {
            e.printStackTrace();
        }
		/*瑙ｆ瀽鏂囦欢*/
		Pattern pattern = Pattern.compile("([\\w|.]+)");
		Matcher match;
        for (String Part: text.toString().split("\n###\n")) {
        	List<String> parts = new ArrayList<>();
        	for (String part: Part.split("\n"))
        		parts.add(part);
        	Parts.add(parts);
        }
        // 鍥剧殑鍚嶅瓧
        data =  Parts.get(0).get(1).split(" ");
        match = pattern.matcher(data[2]);
        if (match.find())
        	graph.setName(match.group());
        else System.out.println("Illegal data!");
        // 鍥剧殑椤剁偣
        if (Parts.get(1).size() > 1) {
        	for (int i = 1; i < Parts.get(1).size(); i++) {
        		data = Parts.get(1).get(i).split(" ");
            	match = pattern.matcher(data[2]);
            	if (match.find()) vertexName = match.group();
            	match = pattern.matcher(data[3]);
            	if (match.find()) vertexType = match.group();
            	for (int j = 4; j < data.length; j++) {
            		match = pattern.matcher(data[j]);
            		if (match.find()) Args.append(match.group() + " ");
            	}
            	String[] args = Args.toString().split(" ");
            	graph.addVertex(vertexFactory.createVertex(vertexType, vertexName, args));
            	Args = new StringBuilder("");
            }
        }
        // 鍥剧殑杈�
        if (Parts.get(2).size() > 1) {
            for (int i = 1; i < Parts.get(2).size(); i++) {
            	List<Vertex> vertices = new ArrayList<>();
            	data = Parts.get(2).get(i).split(" ");
            	match = pattern.matcher(data[2]);
            	if (match.find()) edgeName = match.group();
            	match = pattern.matcher(data[3]);
            	if (match.find()) edgeType = match.group();
            	if (edgeType.equals("SameMovieHyperEdge")) {
            		for (int j = 0; j < data.length; j++) {
            			match = pattern.matcher(data[j]);
                    	if (match.find()) {
                    		for (Vertex v: graph.vertices())
                    			if (v.getLabel().equals(match.group())) vertices.add(0, v);
                    	}
            		}
            	}
            	else {
            		match = pattern.matcher(data[4]);
                	if (match.find()) weight = Double.parseDouble(match.group());
                	match = pattern.matcher(data[5]);
                	if (match.find()) {
                		for (Vertex v: graph.vertices())
                			if (v.getLabel().equals(match.group())) vertices.add(0, v);
                	}
                	if (data.length > 6) {
                		match = pattern.matcher(data[6]);
    	            	if (match.find()) {
    	            		for (Vertex v: graph.vertices())
    	            			if (v.getLabel().equals(match.group())) vertices.add(1, v);
    	            	}
    	            	
                	}
            	}
            	graph.addEdge(edgeFactory.createEdge(edgeType, edgeName, weight, vertices));
            }
        }
		return graph;
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return edgeFactory;
	}

	@Override
	public VertexFactory getVertexFactory() {
		// TODO Auto-generated method stub
		return vertexFactory;
	}

}
