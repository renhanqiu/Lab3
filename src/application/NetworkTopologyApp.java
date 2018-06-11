package application;

import factory.MovieGraphFactory;
import factory.NetworkTopologyFactory;
import graph.MovieGraph;
import graph.NetworkTopology;

public class NetworkTopologyApp {
public static void main(String[] args) {
	NetworkTopology graph = new NetworkTopology();
	Application app = new Application(graph, new NetworkTopologyFactory());
	app.run();
}
}
