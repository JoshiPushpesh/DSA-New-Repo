
import java.util.*;
public class GraphDFS2 {
    private Map<Integer,List<Integer>> adj = new HashMap<>();
    public void adEdge(int u , int v){
        adj.putIfAbsent(u,new ArrayList<>());
        adj.putIfAbsent(v,new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int start,Set<Integer> visited){
        System.out.print(start + " ");
        visited.add(start);
        for(int neighbor : adj.get(start))
        {
            if(!visited.contains(neighbor))
            {
                dfs(neighbor,visited);
            }
        }
    }
    public static void main(String[] args) {
        GraphDFS2 g = new GraphDFS2();
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        g.adEdge(0,1);
        g.adEdge(1,2);
        g.adEdge(2,0);
        g.dfs(0, visited);
    }
}
