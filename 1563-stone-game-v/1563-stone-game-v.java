class Solution {
    private int[] pref;
    private int[][] memo;

    public int stoneGameV(int[] stones) {
        int n = stones.length;
        
        // Build prefix sum array
        pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stones[i];
        }
        
        // Initialize memoization table with -1
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        // Base case: only one stone left
        if (i == j) {
            return 0;
        }
        
        // Return cached result if already calculated
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try every possible split point k
        for (int k = i; k < j; k++) {
            int leftSum = pref[k + 1] - pref[i];
            int rightSum = pref[j + 1] - pref[k + 1];

            int score = 0;
            if (leftSum < rightSum) {
                score = leftSum + solve(i, k);
            } else if (rightSum < leftSum) {
                score = rightSum + solve(k + 1, j);
            } else {
                score = leftSum + Math.max(solve(i, k), solve(k + 1, j));
            }
            
            maxScore = Math.max(maxScore, score);
        }

        return memo[i][j] = maxScore;
    }
}