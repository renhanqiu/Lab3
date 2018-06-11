package factory;

import vertex.Computer;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;

public class NetworkVertexFactory extends VertexFactory {

	@Override
	public Vertex createVertex(String type, String label, String[] args) {
		// TODO Auto-generated method stub
		Vertex network = null;
		switch (type) {
		case "Computer":
			network = new Computer(label);
			break;
		case "Router":
			network = new Router(label);
			break;
		case "Server":
			network = new Server(label);
			break;
		default:
			System.out.println("Illegal type.");
		}
		network.fillVertexInfo(args);
		return network;
	}

}
