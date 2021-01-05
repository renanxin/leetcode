import java.util.*;



class Solution{

    // solution for 523
    public boolean checkSubarraySum(int[] nums, int k) {
        k = k<0?-k:k;
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;++i)
            dp[i] = nums[i];
        int len = nums.length;
        for(int i=1;i<len;++i){
            for(int j=0;j<len-i;++j){
                dp[j]+= nums[j+i];
                if(k!=0){
                    if(dp[j]%k==0)
                        return true;
                }else{
                    if(dp[j]==0)
                        return true;
                }
            }
        }
        return false;
    }
}
