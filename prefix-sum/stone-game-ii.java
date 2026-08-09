class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int M, int[] piles,
                      int[] suffix, Integer[][] dp) {

        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int maxStones = 0;

        for (int x = 1; x <= 2 * M; x++) {

            int opponent = solve(
                i + x,
                Math.max(M, x),
                piles,
                suffix,
                dp
            );

            int currentPlayer = suffix[i] - opponent;

            maxStones = Math.max(maxStones, currentPlayer);
        }

        return dp[i][M] = maxStones;
    }
}
