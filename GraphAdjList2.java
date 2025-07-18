import java.util.*;
public class GraphAdjList2 {
    private Map<String, List<String>> adjList = new HashMap<>();

    GraphAdjList2(){

    }
    public void addVertix(String v){

        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void adEdge(String src ,String dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void printGraph(){
        for(String vertex : adjList.keySet())
        {
            System.out.println(vertex + "--> " + adjList.get(vertex));
        }
    }
    public static void main(String[] args) {
        GraphAdjList2 graph = new GraphAdjList2();
        graph.addVertix("A");
        graph.addVertix("B");
        graph.addVertix("C");
        graph.adEdge("A","B");
        graph.adEdge("B","C");
        graph.printGraph();

    }
}
