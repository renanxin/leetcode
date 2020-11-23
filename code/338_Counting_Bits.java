import java.util.*;



class Solution{

    // solution for 338
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        if(num>=1)
            dp[1] = 1;
        if(num>=2)
            dp[2] = 1;
        if(num>=3){
            for(int i=1;i<=num;++i){
                if(i%2==0)
                    dp[i] = dp[i/2];
                else
                    dp[i] = dp[i/2] + 1;
            }
        }
        return dp;
    }
}
