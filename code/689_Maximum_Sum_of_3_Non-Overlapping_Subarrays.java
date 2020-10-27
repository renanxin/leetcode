class Solution {
    // solution for 689
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[4][nums.length];
        int[] res = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        int tmp = 0;
        for(int i=0;i<k-1;++i)
            tmp += nums[i];
        for(int i=k-1;i<nums.length;++i){
            tmp += nums[i];
            dp[0][i] = tmp;
            tmp -= nums[i-k+1];
        }
        dp[1][k-1] = dp[0][k-1];
        dp[2][2*k-1] = dp[0][2*k-1] + dp[1][k-1];
        dp[3][3*k-1] = dp[0][3*k-1] + dp[2][2*k-1];
        for(int i=k;i<nums.length;++i)
            dp[1][i] = dp[0][i]>dp[1][i-1]?dp[0][i]:dp[1][i-1];
        for(int j=2;j<4;++j)
            for(int i=j*k;i<nums.length;++i)
                dp[j][i] = dp[j][i-1]>dp[j-1][i-k]+dp[0][i]?dp[j][i-1]:dp[j-1][i-k]+dp[0][i];
        int i=3,l=nums.length-1,val = dp[3][nums.length-1];
        while(i>0 && l>=0){
            if(val==dp[i][l]){
                res[i-1] = res[i-1]>l-k+1?l-k+1:res[i-1];
                l--;
                if(l>=0 && val!=dp[i][l]){
                    val -= dp[0][l+1];
                    --i;
                }
            }else
                l--;
        }
        return res;
    }
}