import java.util.*;

public class StronglyConnectedComponents {

    private static void dfs1(int node, boolean[] visited,
                             List<List<Integer>> graph, Stack<Integer> stack) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs1(nei, visited, graph, stack);
            }
        }
        stack.push(node);
    }

    private static void dfs2(int node, boolean[] visited,
                             List<List<Integer>> reversedGraph) {
        visited[node] = true;
        for (int nei : reversedGraph.get(node)) {
            if (!visited[nei]) {
                dfs2(nei, visited, reversedGraph);
            }
        }
    }

    public static int countSCC(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        // Build graphs
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            reversedGraph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Order vertices by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, visited, graph, stack);
            }
        }

        // Step 2: DFS on reversed graph
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, visited, reversedGraph);
                sccCount++;
            }
        }

        return sccCount;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {1, 0},
                {0, 2},
                {2, 1},
                {0, 3},
                {3, 4}
        };

        System.out.println("Number of SCCs: " + countSCC(V, edges));
    }
}
