package vertex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server extends Vertex {
	private String label;
	private String HostName;
	public Server(String label) {
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
		Pattern pattern = Pattern.compile("([0-9]+).([0-9]+).([0-9]+).([0-9]+)");
		Matcher match = pattern.matcher(HostName);
		assert match.matches() == true;
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
		return "Server";
		
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
		Server other = (Server) obj;
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
		return "Server [label=" + label + ", HostName=" + HostName + "]";
	}
	
	
}
