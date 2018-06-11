package factory;

import edge.Edge;
import graph.Graph;
import graph.NetworkTopology;
import vertex.Vertex;

public class NetworkTopologyFactory  extends GraphFactory {

	@Override
	public Graph<Vertex, Edge> createGraph(String filePath) {
		// TODO Auto-generated method stub
		ConcreteGraphFactory factory=new ConcreteGraphFactory(new NetworkTopology(), new NetworkTopologyFactory());
		return factory.createGraph(filePath);
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return new NetworkConnectionFactory();
	}

	@Override
	public VertexFactory getVertexFactory() {
		// TODO Auto-generated method stub
		return new NetworkVertexFactory();
	}

}
