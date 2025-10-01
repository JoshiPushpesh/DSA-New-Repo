import java.util.*;

class CoinChangeSolver {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 🔹 Demo
    public static void main(String[] args) {
        CoinChangeSolver solver = new CoinChangeSolver();
        int[] coins = {1, 2, 5};
        int a
