package vertex;

public class Movie extends Vertex {
	private String label;
	private int year;
	private String country;
	private double score;
	public Movie(String label) {
		super(label);
		this.label=label;
	}
	protected void checkRep() {
		assert label!=null;
		assert year >= 1990 && year <= 2018;
		assert country != null;
		assert score >= 0 && score <= 10;
	}
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		year=Integer.parseInt(args[0]);
		country=args[1];
		score=Double.parseDouble(args[2]);
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getType() {
		return "Movie";
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + year;
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
		Movie other = (Movie) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie [label=" + label + ", year=" + year + ", country=" + country + ", score=" + score + "]";
	}

}
