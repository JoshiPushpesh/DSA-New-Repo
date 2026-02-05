import java.util.*;

public class CheapestFlightsWithKStops {

    public static int findCheapestPrice(int n, int[][] flights,
                                        int src, int dst, int k) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges k+1 times
        for (int i = 0; i <= k; i++) {
            int[] temp = dist.clone();

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + cost < temp[v]) {
                    temp[v] = dist[u] + cost;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,3,100},
                {0,3,500}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println("Cheapest Price: " +
                findCheapestPrice(n, flights, src, dst, k));
    }
}
