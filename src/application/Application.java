package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import edge.Edge;
import factory.ConcreteGraphFactory;
import factory.EdgeFactory;
import factory.GraphFactory;
import factory.VertexFactory;
import graph.Graph;
import helper.Centrality;
import helper.GraphMetrics;
import helper.ParseCommandHelper;
import helper.betweennessCentrality;
import helper.closenessCentrality;
import helper.degreeCentrality;

import vertex.Vertex;

public class Application {
	private Graph<Vertex, Edge> graph;
    private final GraphFactory graphFactory;
    private final VertexFactory vertexFactory;
    private final EdgeFactory edgeFactory;
    private final Logger log = Logger.getLogger("ExceptionLog");
    public Application(Graph<Vertex, Edge> graph, GraphFactory graphFactory) {
        this.graphFactory = graphFactory;
        this.graph = graph;
        this.vertexFactory = graphFactory.getVertexFactory();
        this.edgeFactory = graphFactory.getEdgeFactory();
    }
    private Vertex getVertex(String label) {
        for (Vertex vertex: graph.vertices())
            if (vertex.getLabel().equals(label)) return vertex;
        System.out.println("This vertex doesn't exist.");
        return null;
    }
    
    public void run() {
    	String filepath = "src/text/Logger.txt";
    	try {
    				FileHandler fileHandler= new FileHandler(filepath);
    				fileHandler.setLevel(Level.INFO);
    		    	fileHandler.setFormatter(new MyLogHandler());
    		    	log.addHandler(fileHandler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	Scanner scan = new Scanner(System.in);
		System.out.print("Text Path: ");
		String path = scan.nextLine();
		String command = null;
		graph = new ConcreteGraphFactory(graph, graphFactory).createGraph(path);
		System.out.println("This graph has been built successfully, input your choice.");
        String choice = scan.nextLine();
        while (true) {
        	switch (choice) {
            case "display":
                System.out.println(graph.toString());
                break;
            case "operate":
            	System.out.print("Command: ");
				command = scan.nextLine();
				ParseCommandHelper.parseHelper(graph, vertexFactory, edgeFactory, command, scan);
                break;
            case "vertex":
            	System.out.print("Command: ");
            	command = scan.nextLine();
            	String vertexData[] = command.split(" ");
            	Centrality centrality = null;
            	switch (vertexData[0]) {
            	case "degree":
            		if (graph.getType().equals("GraphPoet") || graph.getType().equals("SocialNetwork"))
            			System.out.println("inDegree: " + GraphMetrics.inDegreeCentrality(graph, getVertex(vertexData[1])) +
            							 "\noutDegree: " + GraphMetrics.outDegreeCentrality(graph, getVertex(vertexData[1])));
            		else {
            			centrality = new Centrality(new degreeCentrality());
            			System.out.println(centrality.getCentrality(graph, getVertex(vertexData[1])));
            		}
            		break;
            	case "closeness":
            		centrality = new Centrality(new closenessCentrality());
            		System.out.println(centrality.getCentrality(graph, getVertex(vertexData[1])));
            		break;
            	case "betweenness":
            		centrality = new Centrality(new betweennessCentrality());
            		System.out.println(centrality.getCentrality(graph, getVertex(vertexData[1])));
            		break;
            	case "eccentricity":
            		System.out.println(GraphMetrics.eccentricity(graph, getVertex(vertexData[1])));
            		break;
            	default:
            		System.out.println("Illegal command.");
            	}
            	break;
            case "graph":
            	System.out.print("Command: ");
            	command = scan.nextLine();
            	switch (command) {
            	case "degree-centrality":
            		System.out.println(GraphMetrics.degreeCentrality(graph));
            		break;
            	case "radius":
                	System.out.println(GraphMetrics.radius(graph));
            		break;
            	case "diameter":
            		System.out.println(GraphMetrics.diameter(graph));
            		break;
            	default:
            		System.out.println("Illegal command.");
            		log.info("Illegal command");
            	}
            	break;
            case "distance":
            	System.out.print("Command: ");
            	command = scan.nextLine();
            	String data[] = command.split(" ");
            	System.out.println(GraphMetrics.distance(graph, getVertex(data[0]), getVertex(data[1])));
        		break;
            case "other":
            	System.out.print("Command: ");
            	command = scan.nextLine();
            	String other[] = command.split(" ");
            	switch (other[0]) {
            	case "GraphPoet":
            		int n = Integer.parseInt(other[1]);
            		List<Edge> rmv = new ArrayList<>();
            		for (Edge edge: graph.edges())
            			if (edge.getWeight() < n) rmv.add(edge);
            		for (Edge edge: rmv) graph.removeEdge(edge);
            		System.out.println("Delete successfully.");
            		break;
            	case "SocialNetwork":
            		for (Vertex vertex: graph.vertices()) {
            			vertex.setWeight(GraphMetrics.inDegreeCentrality(graph, vertex));
            			System.out.println(vertex.toString() + "-" + vertex.getWeight());
            		}
            		break;
            	default:
            		System.out.println("Sorry, we don't have more operate.");
            	}
            	break;
        	default:
        		System.out.println("Illegal command.");
        	}
        	choice = scan.nextLine();
        }
    }
    
	public GraphFactory getGraphFactory() {
		return this.graphFactory;
	}
	public VertexFactory getVertexFactory() {
		return this.vertexFactory;
	}
	public EdgeFactory getEdgeFactory() {
		return this.edgeFactory;
	}
    
}
class MyLogHandler extends Formatter{
	public String format(LogRecord record) { 
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateFormat = sdf.format(record.getMillis());
	return record.getLevel() + ": [Time: " + dateFormat + "] [Class: " + record.getSourceClassName() + "] [Method: " + record.getSourceMethodName() + "] [Message: " + record.getMessage() + "]\n"; 
	   
	}
}
