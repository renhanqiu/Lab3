package edge;

import java.util.Objects;

public class MovieDirectorRelation extends UndirectedEdge {
	private String label;
	private double weight;
	
	public MovieDirectorRelation(String label, double weight) {
		super(label, weight);
		this.label = label;
		this.weight = weight;
	}
	
	@Override protected void checkRep() {
		assert label != null;
		assert weight == -1;
		assert vertices().size() == 2;
		assert sourceVertices().size() == 2;
		assert targetVertices().size() == 2;
	}

	@Override public String getType() {
		return "MovieDirectorRelation";
	}
	
	@Override public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;
    	if (!super.equals(o)) return false;
    	MovieDirectorRelation edge = (MovieDirectorRelation) o;
    	return Objects.equals(label, edge.label)
    		&& Objects.equals(weight, edge.weight);
    }
}
