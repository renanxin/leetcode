import java.util.*;



class Solution{

    // solution for 416
    public boolean canPartition(int[] nums) {
        int total_sum = 0;
        for(int num:nums)
            total_sum+=num;
        if(total_sum%2!=0)
            return false;
        total_sum /= 2;
        boolean[][] dp = new boolean[nums.length+1][total_sum+1];
        for(int i=0;i<=total_sum;++i)
            dp[0][i] = (i==0);
        for(int i=1;i<=nums.length;++i){
            dp[i][0] = true;
            for(int j=1;j<=total_sum;++j){
                dp[i][j] = dp[i-1][j];
                if(!dp[i][j]){
                    if(j>=nums[i-1])
                        dp[i][j] = dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][total_sum];
    }
}
