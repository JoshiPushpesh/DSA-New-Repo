import java.util.*;
public class WeightedGraph2 {
    private Map<Integer , List <int[]>> adj = new HashMap<>();

    public void adEdge(int u, int v, int weight)
    {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(new int[]{v,weight});
        adj.get(v).add(new int[]{u,weight}); // undirected

    }

    public void printGraph(){
        for(int u : adj.keySet())
        {
            System.out.print(u + " -->");
            for(int[] edge : adj.get(u))
            {
                System.out.print("("+ edge[0]+","+ edge[1] + ")");
            }
            System.out.println();
        }
    }
 public static void main(String[] args) {
    WeightedGraph2 g = new WeightedGraph2();
    g.adEdge(0, 1, 4);
    g.adEdge(0, 2, 3);
    g.adEdge(1, 2, 5);
    g.printGraph();
 }   
}
