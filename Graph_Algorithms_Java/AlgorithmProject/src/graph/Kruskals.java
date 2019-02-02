package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kruskals 
{
	String type = null;
	String startNode = null;
	int vertex_count = 0;
	int edges_count = 0;
	Graph graph = new Graph();
	List<String> vertex_list;
	String str[];
	public void rf() {
		File file = new File("src/graph/sample3.txt");
                //File file = new File("src/graph/sample2.txt");
		//File file = new File("src/graph/Undirected.txt");
                //File file = new File("src/graph/Undirected1.txt");
                //File file = new File("src/graph/Undirected2.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			str = sc.nextLine().split(" ");
			vertex_count = Integer.parseInt(str[0]);
			edges_count = Integer.parseInt(str[1]);
			type = str[2];
			generateGraph(sc);
			if (type.equalsIgnoreCase("U")) {
				Mst();
			} else if (type.equalsIgnoreCase("D")) {
				System.out.println("Please provide undirected graphs only...");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
        public void Mst() {
		List<Edge> result = new ArrayList<>();
		List<Subvalues> sList = new ArrayList<>();
		int i = 0, e=0;
		for (int j=0; j<vertex_count; j++) {
			Subvalues s= new Subvalues(vertex_list.get(j),vertex_list.get(j));
			sList.add(s);
		}
		while (e < vertex_count - 1) {
			Edge next_edge = new Edge();
			next_edge = graph.getEdges().get(i);
			i++;
			String x = subNodes(sList, next_edge.src);
			String y = subNodes(sList, next_edge.dest);
			if (!x.equalsIgnoreCase(y)) {
				result.add(next_edge);
				e++;
				merge(sList, x, y);
			}
		}
		
		int tlwt = 0;
                // Loop to print all result found.
		for (i = 0; i < result.size(); ++i) {
			tlwt = tlwt + result.get(i).weight;
			System.out.println(result.get(i).src + " ---> " + result.get(i).dest + " ---> " + result.get(i).weight);
		}
		System.out.println("Total Weight "+ tlwt);
	}
        public void merge(List<Subvalues> sub, String v1, String v2) { 
		
		String Root1 = subNodes(sub, v1);
		
		String Root2 = subNodes(sub, v2); 
		
		int i=0, x = 0, y = 0;
		for(i=0;i<sub.size();i++) {
			if(sub.get(i).node.equalsIgnoreCase(Root1)) {
				x = i;
			}
			if(sub.get(i).node.equalsIgnoreCase(Root2)) {
				y = i;
			}
		}
		if (sub.get(x).rank < sub.get(y).rank) {
			sub.get(x).parent = Root2; 
		
		}
		else if (sub.get(x).rank > sub.get(y).rank) {
			sub.get(y).parent = Root1; 
		
		}
		else{ 
			sub.get(y).parent = Root1; 
			sub.get(x).rank++; 
		
		} 
	}
	public String subNodes(List<Subvalues> s, String vertex) {
		for(int j=0; j<s.size();j++) {
			if(s.get(j).node.equals(vertex)) {
				if(!s.get(j).parent.equals(vertex)) {
					s.get(j).parent = subNodes(s, s.get(j).parent);
					return s.get(j).parent;
				}else {
					return s.get(j).parent;
				}
			}
		}
		return vertex;
	}

	public void generateGraph(Scanner sc) {
		while (sc.hasNextLine()) {
			str = sc.nextLine().split(" ");
			if(str.length>1) {
				Edge e= new Edge();
				e.src= str[0];
				e.dest = str[1];
				e.weight = Integer.parseInt(str[2]);
				graph.addEdge(e);
			}
		}
		List<String> llist = new ArrayList<>();
		for (int i = 0; i < graph.edge.size(); i++) {
			llist.add(graph.edge.get(i).src);
			llist.add(graph.edge.get(i).dest);
		}
		vertex_list = llist.stream().distinct().collect(Collectors.toList());
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kruskals kruskal = new Kruskals();
		kruskal.rf();
	}


}
