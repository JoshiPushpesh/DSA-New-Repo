import java.util.*;

class BellmanFordSolverX {

    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }

    public int[] bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.weight < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.weight;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.weight < dist[e.v]) {
                System.out.println("Negative weight cycle detected!");
                return new int[]{};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        BellmanFordSolverX solver = new BellmanFordSolverX();

        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, -3));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(3, 1, 6));

        int[] result = solver.bellmanFord(V, edges, 0);

        System.out.println("Shortest distances from source:");
        System.out.println(Arrays.toString(result));
    }
}
