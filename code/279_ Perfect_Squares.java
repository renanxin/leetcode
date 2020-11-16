import java.util.*;



class Solution{

    // solution for 279
    public int numSquares(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;++i){
            dp[i] = i;      // 设置初始值即最大值
            int s = (int) Math.sqrt(i);
            if(i-s*s==0)
                dp[i]=1;
            else{
                for(int k=1;k<=s;++k){
                    dp[i] = Math.min(dp[i],dp[i-k*k]+1);
                }
            }
        }
        return dp[n];
    }
}
