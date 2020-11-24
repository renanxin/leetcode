import java.util.*;



class Solution{

    // solution for 343
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=5;i<=n;++i){
            int left=1,right = i-1;
            while(left<=right){
                dp[i] = Math.max(dp[i],Math.max(dp[left],left)*Math.max(dp[right],right));
                ++left;
                --right;
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
