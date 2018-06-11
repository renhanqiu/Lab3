package vertex;

public class Person extends Vertex{
	
	private String label;
	private String sex;
	private int age;
	public Person(String label) {
		super(label);
		this.label=label;
		// TODO Auto-generated constructor stub
	}
	public void chectRep() {
		assert label != null;
		assert age > 0;
		assert sex.equals("M") || sex.equals("F");
	}
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		this.sex = args[0];
		this.age = Integer.parseInt(args[1]);
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return "Person";
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
		Person other = (Person) obj;
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
		return "Person [label=" + label + ", sex=" + sex + ", age=" + age + "]";
	}

}
