import java.util.*;

class CityConnectorMST {
    public int minimumCost(int n, int[][] connections) {
        // Sort edges by cost
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int totalCost = 0, edgesUsed = 0;

        for (int[] conn : connections) {
            int u = conn[0], v = conn[1], cost = conn[2];
            if (union(parent, u, v)) {
                totalCost += cost;
                edgesUsed++;
                if (edgesUsed == n - 1) return totalCost; // MST complete
            }
        }
        return -1; // Not all cities connected
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        CityConnectorMST solver = new CityConnectorMST();
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        int n = 3;
        System.out.println(solver.minimumCost(n, connections)); // Output: 6
    }
}
