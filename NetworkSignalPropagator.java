import java.util.*;

class NetworkSignalPropagator {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // Min-heap for Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], time = cur[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, time);

            if (!graph.containsKey(node)) continue;
            for (int[] nei : graph.get(node)) {
                int next = nei[0], newTime = time + nei[1];
                if (!dist.containsKey(next)) {
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        if (dist.size() != n) return -1;
        int maxTime = 0;
        for (int t : dist.values()) maxTime = Math.max(maxTime, t);
        return maxTime;
    }

    // 🔹 Demo
    public static void main(String[] args) {
        NetworkSignalPropagator solver = new NetworkSignalPropagator();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(solver.networkDelayTime(times, n, k)); // Output: 2
    }
}
