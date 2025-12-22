class CoinChangeCounterX2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make amount 0

        // Coin-first loop ensures combinations (not permutations)
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeCounterX2 solver = new CoinChangeCounterX2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("Number of combinations: " + solver.change(amount, coins));
    }
}
