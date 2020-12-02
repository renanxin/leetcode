import java.util.*;



class Solution{

    // solution for 377
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        for(int i=0;i<nums.length;++i) {
            if(nums[i]>target)
                break;
            dp[nums[i]] = 1;
        }
        for(int i=1;i<=target;++i){
            if(dp[i]==0)
                continue;
            for(int j=0;j<nums.length;++j){
                if(i+nums[j]>target)
                    break;
                dp[i+nums[j]] += dp[i];
            }
        }
        return dp[target];
    }
}
