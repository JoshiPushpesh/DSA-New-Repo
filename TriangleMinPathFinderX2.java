import java.util.*;

class TriangleMinPathFinderX2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        // Bottom-up DP
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        TriangleMinPathFinderX2 solver = new TriangleMinPathFinderX2();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Minimum path sum in triangle: " + solver.minimumTotal(triangle));
    }
}
