package vertex;

public class Actor extends Vertex {
	private String label;
	private int age;
	private String sex;
	public Actor(String label) {
		super(label);
		this.label = label;
	}
  protected void checkRep() {
		assert label != null;
		assert age > 0;
		assert sex.equals("M") || sex.equals("F");
	}
	
	@Override public void fillVertexInfo(String[] args) {
		this.age = Integer.parseInt(args[0]);
		this.sex = args[1];
	}
	
	@Override public void setLabel(String label) {
		this.label = label;
	}
	
	@Override public String getLabel() {
		return label;
	}
	
	public String getSex() {
		return sex;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override public String getType() {
		return "Actor";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Actor))
			return false;
		Actor other = (Actor) obj;
		if (age != other.age)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Actor [label=" + label + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
