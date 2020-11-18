import java.util.*;



class Solution{

    // solution for 322
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;++i)
            dp[i] = -1;
        for(int i=0;i<amount;++i){
            for(int coin:coins){
                if(dp[i]!=-1 && (long)i+coin<=amount) {
                    if (dp[i + coin] == -1)
                        dp[i + coin] = dp[i] + 1;
                    else
                        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }
        return dp[amount];
    }
}
