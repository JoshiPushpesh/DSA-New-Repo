import java.util.*;

public class MinSpeedToArrive {
    
    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = (int)1e7;
        int answer = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canReach(dist, hour, mid)) {
                answer = mid;
                right = mid - 1; // try to minimize the speed
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }

    private static boolean canReach(int[] dist, double hour, int speed) {
        double totalTime = 0.0;
        
        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / speed;
            if (i != dist.length - 1) {
                totalTime += Math.ceil(time);
            } else {
                totalTime += time; // last one can be fractional
            }
        }
        
        return totalTime <= hour;
    }

    public static void main(String[] args) {
        int[] dist1 = {1, 3, 2};
        double hour1 = 2.7;
        System.out.println(minSpeedOnTime(dist1, hour1)); // Output: 3

        int[] dist2 = {1, 3, 2};
        double hour2 = 1.9;
        System.out.println(minSpeedOnTime(dist2, hour2)); // Output: -1

        int[] dist3 = {1, 3, 2};
        double hour3 = 6.0;
        System.out.println(minSpeedOnTime(dist3, hour3)); // Output: 1
    }
}
