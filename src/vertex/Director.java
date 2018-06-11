package vertex;

public class Director extends Vertex{
	
	private String label;
	private int age;
	private String sex;
	
	public Director(String label) {
		super(label);
		label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		age=Integer.parseInt(args[0]);
		sex=args[1];
	}
	protected  void checkRep() {
		assert label != null;
		assert age > 0;
		assert sex.equals("M") || sex.equals("F");

	}
	public String getType()
	{
		return "Director";
		
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
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
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
		return "Director [label=" + label + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
