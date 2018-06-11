package edge;

import java.util.Objects;

public class MovieActorRelation extends UndirectedEdge{
	private String label;
	private double weight;
	
	public MovieActorRelation(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override public String getType() {
		return "MovieActorRelation";
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight > 0;
		assert vertices().size() == 2;
		assert sourceVertices().size() == 2;
		assert targetVertices().size() == 2;
	}
	
	@Override
	public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	MovieActorRelation edge = (MovieActorRelation) o;
    	return Objects.equals(label, edge.label)
    		&& Objects.equals(weight, edge.weight);
    }
}
