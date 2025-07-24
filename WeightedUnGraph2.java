import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedUnGraph2 {

   private Map<String , List <String[]>> adj = new HashMap<>();

    public void adEdge(String u, String v, int weight)
    {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(new String[]{v,Integer.toString(weight)});
        adj.get(v).add(new String[]{u,Integer.toString(weight)});
        // adj.get(v).add(new int[]{u,weight}); // undirected

    }

    public void printGraph(){
        for(String u : adj.keySet())
        {
            System.out.print(u + " -->");
            for(String[] edge : adj.get(u))
            {
                System.out.print("("+ edge[0]+","+ edge[1] + ")");
            }
            System.out.println();
        }
    }
 public static void main(String[] args) {
    WeightedUnGraph2 g = new WeightedUnGraph2();
    g.adEdge("A", "B", 4);
    g.adEdge("B", "C", 2);
    g.adEdge("B", "D", 1);
    g.adEdge("C", "E", 8);
    g.adEdge("D", "A", 5);
    g.adEdge("E", "D", 10);
    g.printGraph();
 }   
}
