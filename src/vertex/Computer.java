package vertex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer extends Vertex {
private String label;
private String HostName;
public Computer(String label) {
	super(label);
	this.label = label;
}
@Override
public void fillVertexInfo(String[] args) {
	// TODO Auto-generated method stub
	HostName=args[0];
}
protected void checkRep() {
	
	assert label != null;
	Pattern pattern = Pattern.compile("(\\d+)[.](\\d+)[.](\\d+)[.](\\d+)");
	Matcher match = pattern.matcher(HostName);
	assert match.matches() == true;
	String[] num = HostName.split(".");
	for (int i = 0; i < num.length; i++)
		assert Integer.valueOf(num[i]) >= 0 && Integer.valueOf(num[i]) < 256;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getHostName() {
	return HostName;
}
public void setHostName(String hostName) {
	HostName = hostName;
}
public String getType() {
	return "Computer";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((HostName == null) ? 0 : HostName.hashCode());
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
	Computer other = (Computer) obj;
	if (HostName == null) {
		if (other.HostName != null)
			return false;
	} else if (!HostName.equals(other.HostName))
		return false;
	if (label == null) {
		if (other.label != null)
			return false;
	} else if (!label.equals(other.label))
		return false;
	return true;
}
@Override
public String toString() {
	return "Computer [label=" + label + ", HostName=" + HostName + "]";
}

}
