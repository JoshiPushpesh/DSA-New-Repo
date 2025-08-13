import java.util.*;

public class QueueReconstruction {

    public static int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort by height (desc), then k (asc)
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        // Step 2: Insert into list at index = k
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }

        // Convert back to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {
            {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };

        int[][] result = reconstructQueue(people);

        System.out.println("Reconstructed queue:");
        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }
    }
}
