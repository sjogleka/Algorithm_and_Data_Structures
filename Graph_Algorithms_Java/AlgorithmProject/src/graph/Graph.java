package graph;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Graph {
	
	List<Edge> edge = new ArrayList<>();
	public void addEdge(Edge e) {
        edge.add(e);
        edge.sort(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight; 
			}
        	
        }); 
    }

    public List<Edge> getEdges() {
        return edge;
    }
}
