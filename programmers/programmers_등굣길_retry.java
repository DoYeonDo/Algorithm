class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for(int[] puddle:puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }

        dp[0][0] = 1;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(dp[row][col]==-1) continue;

                if(row!=0 && dp[row-1][col]>0)
                    dp[row][col] += dp[row-1][col] % MOD;
                if(col!=0 && dp[row][col-1]>0)
                    dp[row][col] += dp[row][col-1] % MOD;
            }
        }

        return dp[n-1][m-1] % MOD;
    }
}