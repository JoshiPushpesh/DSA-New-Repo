import java.util.*;

class GraphComponentCounterX {

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Build adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, graph, visited);
        }
    }

    public static void main(String[] args) {
        GraphComponentCounterX counter = new GraphComponentCounterX();

        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        System.out.println("Number of components (Graph 1): " + counter.countComponents(5, edges1)); // 2
        System.out.println("Number of components (Graph 2): " + counter.countComponents(5, edges2)); // 1
    }
}
