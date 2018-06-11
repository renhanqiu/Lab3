package application;

import factory.GraphPoetFactory;

public class GraphPoetApp {
public static void main(String[] args) {
	Application app = new Application(new GraphPoet(), new GraphPoetFactory());
	app.run();
}
}
