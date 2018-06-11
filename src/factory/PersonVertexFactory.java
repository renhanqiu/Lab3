package factory;

import vertex.Person;
import vertex.Vertex;

public class PersonVertexFactory extends VertexFactory {
	public Vertex createVertex(String type, String label, String[] args) {
		Vertex vertex = null;
		if (type.equals("Person")) {
			vertex = new Person(label);
			vertex.fillVertexInfo(args);
		}
		else System.out.println("Illegal type.");
		return vertex;
	}
}

