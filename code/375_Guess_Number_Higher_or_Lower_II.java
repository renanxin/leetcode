import java.util.*;



class Solution{

    public int getMoneyAmount_better(int n) {
        if(n<4)
            return n-1;
        int[][] dp = new int[n+1][n+1];
        for(int i=2;i<=n;++i){
            for(int j=i-1;j>0;--j){
                int global_min = Integer.MAX_VALUE;
                for(int k=j+1;k<i;++k){
                    global_min = Math.min(global_min,k+Math.max(dp[j][k-1],dp[k+1][i]));
                }
                dp[j][i] = j+1==i?j:global_min;
            }
        }
        return dp[1][n];
    }

    // 使用备忘录形式
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n+1][n+1];
        return helper(1,n,memo);
    }

    public int helper(int start,int end,int[][] memo){
        if(start>=end)
            return 0;
        if(memo[start][end]>0)  return memo[start][end];
        int res = Integer.MAX_VALUE;
        for (int k = start; k <= end; ++k) {
            int t = k + Math.max(helper(start, k - 1, memo), helper(k + 1, end, memo));
            res = Math.min(res, t);
        }
        return memo[start][end] = res;
    }
}
