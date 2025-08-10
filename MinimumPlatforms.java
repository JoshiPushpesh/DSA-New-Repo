import java.util.*;

public class MinimumPlatforms {

    public static int findMinimumPlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 1;  // At least one platform needed
        int maxPlatforms = 1;
        int i = 1, j = 0;   // Pointers for arrival and departure
        int n = arrival.length;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};

        int result = findMinimumPlatforms(arrivals, departures);
        System.out.println("Minimum number of platforms required: " + result);
    }
}
