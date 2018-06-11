package application;

import factory.SocialNetworkFactory;
import graph.SocialNetwork;

public class SocialNetworkApp {
public static void main(String[] args) {
	SocialNetwork graph = new SocialNetwork();
	Application app = new Application(graph, new SocialNetworkFactory());
	app.run();
}
}
