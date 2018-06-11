package application;

import factory.MovieGraphFactory;
import graph.MovieGraph;

public class MovieGraphApp {
public static void main(String[] args) {
	MovieGraph graph = new MovieGraph();
	Application app = new Application(graph, new MovieGraphFactory());
	app.run();
	
}
}
