package graph;

public class Subvalues {
	String node;
	int rank = 0;
	String parent;
	public Subvalues(String node, String parent) {
		super();
		this.node = node;
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Subset [node=" + node + ", rank=" + rank + ", parent=" + parent + "]";
	}
	
}
