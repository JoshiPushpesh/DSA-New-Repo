class RedundantConnectionFinder {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Union-Find helpers
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!union(parent, u, v)) {
                return edge; // This edge creates the cycle
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    private boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA == rootB) return false; // cycle
        parent[rootA] = rootB;
        return true;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        RedundantConnectionFinder solver = new RedundantConnectionFinder();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] ans = solver.findRedundantConnection(edges);
        System.out.println("[" + ans[0] + "," + ans[1] + "]"); // Output: [2,3]
    }
}
