package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edge.Edge;
import factory.EdgeFactory;
import factory.VertexFactory;
import graph.Graph;
import vertex.Vertex;

public class ParseCommandHelper {
	static public void parseHelper(Graph<Vertex, Edge> g, VertexFactory vertexFactory, EdgeFactory edgeFactory, String command, Scanner scan) {
		String[] data = command.split(" ");
		String choice = null;
		if (data[0].equals("vertex")) {
			if (data[1].equals("--add")) {
				String[] info = null;
				System.out.print("Information: ");
				choice = scan.nextLine();
				if (!choice.equals("null")) info = choice.split(" ");
				if (g.addVertex(vertexFactory.createVertex(data[3], data[2], info)))
					System.out.println("Add successfully.");
			}
			else if (data[1].equals("--delete")) {
				List<Vertex> vertices = new ArrayList<>();
				Pattern pattern = Pattern.compile(data[2]);
				Matcher match;
				for (Vertex vertex: g.vertices()) {
					match = pattern.matcher(vertex.getLabel());
					while (match.find()) vertices.add(vertex);
				}
				System.out.println("Delete it? Y|N");
				choice = scan.nextLine();
				if (choice.equals("Y"))
					for (Vertex vertex: vertices) g.removeVertex(vertex);
				System.out.println("Delete successfully.");
			}
			else if (data[1].equals("--change")) {
				System.out.println("1.label\t2.information");
				choice = scan.nextLine();
				if (choice.equals("1")) {
					System.out.print("Old label: ");
					choice = scan.nextLine();
					System.out.print("New label: ");
					String newLabel = scan.nextLine();
					getVertex(g, choice).setLabel(newLabel);
					System.out.println("Change label successfully.");
				}
				else if (choice.equals("2")) {
					System.out.print("Vertex: ");
					choice = scan.nextLine();
					Vertex v = getVertex(g, choice);
					if (v != null) {
						System.out.println("Informations: ");
						String[] info = scan.nextLine().split(" ");
						v.fillVertexInfo(info);
					}
					System.out.println("Change information successfully.");
				}
				else System.out.println("Illegal choice.");
			}
		}
		else if (data[0].equals("edge")) {
			double weight = -1;
			String weighted = null, directed = null;
			Vertex src = null, dst = null;
			if (data[1].equals("--add")) {
				Pattern pattern = Pattern.compile("Y|N");
				Matcher match;
				for (Edge edge: g.edges())
					if (edge.getLabel().equals(data[2])) System.out.println("Illegal label.");
				match = pattern.matcher(data[4]);
				if (match.find()) {
					weighted = match.group();
					weight = Double.parseDouble(data[5]);
				}
				match = pattern.matcher(data[6]);
				if (match.find()) directed = match.group();
				Pattern p = Pattern.compile("([\\w]+)");
	    		Matcher m = p.matcher(data[7]);
	    		List<Vertex> V = new ArrayList<>();
	    		if (m.find()) {
	    			V.add(getVertex(g, m.group())); 
					V.add(getVertex(g, data[8]));
	    		}
				boolean judge = false;
				for (Edge edge: g.edges()) {
					if (edge.sourceVertices().contains(src) && edge.targetVertices().contains(dst)) {
						System.out.println("This edge has existed.");
						judge = true;
					}
				}
				if (!judge && g.legalEdge(data[3], weighted, directed)) {
					if (!g.getType().equals("NetworkTopology"))
						g.addEdge(edgeFactory.createEdge(data[3], data[2], weight, V));
					else if (!V.get(0).getType().equals(V.get(1).getType()))
						g.addEdge(edgeFactory.createEdge(data[3], data[2], weight, V));
					else System.out.println("Can't add edge.");
					System.out.println("Add successfully.");
				}
				else System.out.println("Can't add this edge.");
			}	
			else if (data[1].equals("--delete")) {
				List<Edge> edges = new ArrayList<>();
				Pattern pattern = Pattern.compile(data[2]);
				Matcher match;
				for (Edge edge: g.edges()) {
					match = pattern.matcher(edge.getLabel());
					while (match.find()) edges.add(edge);
				}
				System.out.println("Delete it? Y|N");
				choice = scan.nextLine();
				if (choice.equals("Y")) {
					for (Edge edge: edges) g.removeEdge(edge);
					System.out.println("Delete successfully.");
				}
			}
			else if (data[1].equals("--change")) {	
				System.out.println("1.label\t2.weight\t3.direction");
				choice = scan.nextLine();
				if (choice.equals("1")) {
					System.out.print("Old label: ");
					choice = scan.nextLine();
					System.out.print("New label: ");
					for (Edge edge: g.edges())
						if (edge.getLabel().equals(choice)) edge.setLabel(scan.nextLine());
					System.out.println("Now the graph is:\n" + g.toString());
				}
				else if (choice.equals("2")) {
					System.out.print("Label: ");
					choice = scan.nextLine();
					System.out.print("Weight: ");
					weight = scan.nextDouble();
					for (Edge edge: g.edges()) {
						if (edge.getLabel().equals(choice)) edge.setWeight(weight);
					}
					System.out.println("Now the graph is:\n" + g.toString());
				}
				else if (choice.equals("3")) {
					System.out.print("Label: ");
					choice = scan.nextLine();
					Edge e = null;
					List<Vertex> V = new ArrayList<>();
					for (Edge edge: g.edges()) {
						if (edge.getLabel().equals(choice)) {
							e = edge;
							for (Vertex v: edge.sourceVertices()) src = v;
							for (Vertex v: edge.targetVertices()) dst = v;
							V.add(dst); V.add(src);
						}
					}
					boolean judge = false;
					for (Edge edge: g.edges()) {
						if (edge.sourceVertices().contains(dst) && edge.targetVertices().contains(src)) {
							System.out.println("Can't change this edge's direction.");
							judge = true;
						}
					}
					if (!judge) e.addVertices(V);
					System.out.println("Change direction successfully.");
				}
				else System.out.println("Illegal choice.");
			}
		}
		else if (data[0].equals("hyperedge")) {
			List<Vertex> V = new ArrayList<>();
			Pattern p = Pattern.compile("([\\w]+)");
			Matcher m;
			boolean judge = false;
			if (g.getType().equals("MovieGraph")) {
				if (data[1].equals("--add")) {
					for (int i = 4; i < data.length; i++) {
						m = p.matcher(data[i]);
			    		if (m.find() && g.targets(getVertex(g, data[2])).containsKey(getVertex(g, m.group()))) 
			    			V.add(getVertex(g, m.group()));
			    		else System.out.println("Illegal vertex.");
					}
					for (Edge edge: g.edges()) {
						if (edge.getLabel().equals(data[2])) {
							edge.addVertices(V);
							judge = true;
						}
					}
					if (!judge) g.addEdge(edgeFactory.createEdge(data[3], data[2], -1, V));
					System.out.println("Add hyperedge successfully.");
				}
				else System.out.println("Illegal operate.");
			}
			else System.out.println("This graph shouldn't contain a hyperedge.");
		}
		else System.out.println("Illegal command.");
	}
	
	static private Vertex getVertex(Graph<Vertex, Edge> g, String label) {
        for (Vertex vertex: g.vertices())
            if (vertex.getLabel().equals(label)) return vertex;
        System.out.println("This vertex doesn't exist.");
        return null;
    }
}
