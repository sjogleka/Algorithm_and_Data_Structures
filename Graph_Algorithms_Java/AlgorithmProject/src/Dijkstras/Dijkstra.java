import java.io.*;
import java.util.*;
 
public class Dijkstra {
    public static int flag ;
    public static int count;
    public static int counter;  
    public static int t,c;
        
    public static void countLines(String file) throws IOException
    {
        Scanner st = new Scanner(new File(x));
        ArrayList<String> list = new ArrayList<String>();
        while (st.hasNext())
        {
            list.add(st.nextLine());
        }
        t = (list.get(list.size()-1)).length();
        //System.out.println(t);
        if (t==1)
        {
            c = list.size()-1;
        }
        else
            c = list.size();
    LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(file)));
    lnr.skip(Long.MAX_VALUE);
    Dijkstra.count=c;
    lnr.close();
    } 
    public static Graph.Edge[] readTextFile(String fileName) {
    String line = null;
    Graph.Edge[] Gr=new Graph.Edge[(Dijkstra.count-1)];
    try {
        Scanner st = new Scanner(new File(x));
        ArrayList<String> list = new ArrayList<String>();
        while (st.hasNext())
        {
            list.add(st.nextLine());
        }
        FileReader fileReader = new FileReader(x);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i=-1,j=0;
        //System.out.println((Dijkstra.count)+" "+(list.size() - 2));
        System.out.println("Given Sequence is : ");
        for(int k = 0; k < c; k++)
        {
                            if (j == 0)
                            {
                                LineNumberReader lnr = null;
                                lnr = new LineNumberReader(fileReader);
                                lnr.skip(4);
                                j++;
                            }
                            else
                            {
                            i=i+1;
                            //System.out.println(list.get(k));
                            String[] tokens = list.get(k).split(" ");
                            String s = tokens[0];
                            String e = tokens[1];
                            int wt =Integer.parseInt(tokens[2]);
                            Gr[i] =new Graph.Edge(s, e, wt);
                            System.out.println(s+" "+ e+" "+ wt);
                            
                            }
                        
        }
        // Always close files.
        bufferedReader.close();
    } catch (FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");
    } catch (IOException ex) {
        System.out.println("Error reading file '" + fileName + "'");
    }
    //return Dijkstra.GRAPH;
    return Gr;
    }

    public static final int STARTER = '1';
    // Taking absolute path of the file.
   public static final String x = "src\\Dijkstras\\Undirected2.txt"; 
   //public static final String x = "src\\Dijkstras\\Undirected1.txt"; 
   //public static final String x = "src\\Dijkstras\\Undirected.txt";
   //public static final String x = "src\\Dijkstras\\Directed.txt";
   //public static final String x = "src\\Dijkstras\\Directed1.txt";
   //public static final String x = "src\\Dijkstras\\Directed2.txt";
   public static void main(String[] args)throws IOException {
       String START;
       byte b;
       String str[];         
       String lastLine = "";
       String sCurrentLine;
       Scanner s = new Scanner(new File(x));
       BufferedReader br = new BufferedReader(new FileReader(x));
       String line = s.nextLine();
       str = s.nextLine().split(" ");
       //START = str[0];
    while ((sCurrentLine = br.readLine()) != null) 
    {
        //System.out.println(sCurrentLine);
        lastLine = sCurrentLine;
    }
    //System.out.println(lastLine +" " +lastLine.length());
    if (lastLine.length() == 1)
    {
        START = lastLine;
        //System.out.println(START);
    }
    else
    {
        START = str[0];
    }
    System.out.println("Taking Source as :- " + START);
      countLines(x); 
      Graph.Edge[] GRAPH=readTextFile(x);
      //System.out.println(GRAPH);
      Graph g = new Graph(GRAPH);
      g.dijkstra(START);
      //g.printPath(END);
      g.printAllPaths();
   }
} 
class Graph {
    public static int flag ;
    String str[];
    String type = null;
    int vertex_count = 0;
    int edges_count = 0;
    private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects
    public  void readFile() // Method To read the file and check if Graph as Directed or Undirected
    {
        File file = new File("src\\Dijkstras\\Undirected2.txt");
        //File file = new File("src\\Dijkstras\\Undirected1.txt");
        //File file = new File("src\\Dijkstras\\Undirected.txt");
        //File file = new File("src\\Dijkstras\\Directed1.txt");
        //File file = new File("src\\Dijkstras\\Directed.txt");
        //File file = new File("src\\Dijkstras\\Directed2.txt");
	Scanner sc;
	try 
        {
            sc = new Scanner(file);
            str = sc.nextLine().split(" ");
            vertex_count = Integer.parseInt(str[0]);
            edges_count = Integer.parseInt(str[1]);
            type = str[2];
            //System.out.println(type);
            if (type.equalsIgnoreCase("U")) {
            	flag = 1;
            } else if (type.equalsIgnoreCase("D")) {
                flag = 0;
            //System.out.println("In D");
            }
	}catch (FileNotFoundException e) 
        {
            e.printStackTrace();
	}
    }
    /** One edge of the graph used by Graph constructor **/
   public static class Edge { 
      public final String v1, v2;
      public final int dist;
      public Edge(String v1, String v2, int dist) {
         this.v1 = v1;
         this.v2 = v2;
         this.dist = dist;
      }
   }
 
   /** Mapping of single vertex to its neighbouring vertices **/
  public static class Vertex implements Comparable<Vertex>{
	public final String name;
	public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
	public Vertex previous = null;
	public final Map<Vertex, Integer> neighbours = new HashMap<>();
 
	public Vertex(String name)
	{
		this.name = name;
	}
 
	private void printPath()
	{
		if (this == this.previous)
		{
			System.out.printf("%s", this.name);
		}
		else if (this.previous == null)
		{
			System.out.printf("%s(node is not reachable from source)", this.name);
		}
		else
		{
			this.previous.printPath();
			System.out.printf(" ---> %s(%d)", this.name, this.dist);
		}
	}
 
	public int compareTo(Vertex other)
	{
		if (dist == other.dist)
			return name.compareTo(other.name);
 
		return Integer.compare(dist, other.dist);
	}
 
	@Override public String toString()// Overrriding the method toString to print in required format
	{
		return "(" + name + ", " + dist + ")";
	}
}
 
   /** Method to construct a graph from a set of edges of particular node **/
   public Graph(Edge[] edges) {
      graph = new HashMap<>(edges.length);
 
      //one pass to find all vertices
      for (Edge e : edges) {
         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
         if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
      }
      readFile(); // Check if the grapg is 'Directed' or 'Undirected'
      //another pass to set neighbouring vertices
      for (Edge e : edges) {
         //System.out.println(flag);
         graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
         if (flag == 1)
         {
         //System.out.println(flag);
         graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // Additional neighbour search in opposite direction for Undirected Graph graph
         }
      }
   }
 
   /** 'Dijkstras' implementation for specified source vertex */ 
   public void dijkstra(String startName) {
      if (!graph.containsKey(startName)) {
         System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
         return;
      }
      final Vertex source = graph.get(startName);
      NavigableSet<Vertex> q = new TreeSet<>();
 
      // Generating all vertices
      for (Vertex v : graph.values()) {
         v.previous = v == source ? source : null;
         v.dist = v == source ? 0 : Integer.MAX_VALUE;
         q.add(v);
      }
 
      dijkstra(q); // Calling function to sort the vertices which are in queue based on distance.
   }
 
   /** Implementation of 'Dijkstras' algorithm using heap. */
   private void dijkstra(final NavigableSet<Vertex> q) {      
      Vertex u, v;
      while (!q.isEmpty()) {
 
         u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
         if (u.dist == Integer.MAX_VALUE) break; 
         //look at distances to each neighbour
         for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
            v = a.getKey(); //the neighbour in this iteration
 
            final int alternateDist = u.dist + a.getValue();
            if (alternateDist < v.dist) { // Check for shortest distance if shorter path to neighbour found
               q.remove(v);
               v.dist = alternateDist;
               v.previous = u;
               q.add(v);
            } 
         }
      }
   }
   /** Prints the path from the source to every vertex */
   public void printAllPaths() {
      System.out.println("Path, Distances of all Vertices from source given :- ");
      for (Vertex v : graph.values()) {
         v.printPath();
         System.out.println();
      }
   }
}
