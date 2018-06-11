package factory;

import edge.Edge;
import graph.Graph;
import graph.SocialNetwork;
import vertex.Vertex;

public class SocialNetworkFactory extends GraphFactory {

	@Override
	public Graph<Vertex, Edge> createGraph(String filePath) {
		// TODO Auto-generated method stub
		ConcreteGraphFactory factory=new ConcreteGraphFactory(new SocialNetwork(),new SocialNetworkFactory());
		
		return factory.createGraph(filePath);
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return new SocialEdgeFactory();
	}

	@Override
	public VertexFactory getVertexFactory() {
		// TODO Auto-generated method stub
		return new PersonVertexFactory();
	}

}
