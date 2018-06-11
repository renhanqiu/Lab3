package vertex;

public class Word extends Vertex{
   private String label;
	
	public Word(String label) {
		super(label);
		this.label = label;
	}
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return "word";
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Word [label=" + label + "]";
	}
	

}
