package factory;

import vertex.Vertex;
import vertex.Word;

public class WordVertexFactory extends VertexFactory {

	@Override
	public Vertex createVertex(String type, String label, String[] args) {
		// TODO Auto-generated method stub
		Vertex vertex=null;
		if(type.equals("Word")) {
			vertex=new Word(label);
			vertex.fillVertexInfo(args);
			
		}
		else {
			System.out.println("Illegal type.");
		}
		
		return vertex;
	}

}
