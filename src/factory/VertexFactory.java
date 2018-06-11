package factory;

import vertex.Vertex;

public abstract class VertexFactory {
abstract public Vertex createVertex(String type, String label, String[] args);
}
