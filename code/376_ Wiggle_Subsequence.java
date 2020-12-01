import java.util.*;



class Solution{

    // solution for 376
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<3)
            return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int sub = 0;
        for(int i=1;i<nums.length;++i){
            if(sub==0 && nums[i-1]!=nums[i] || sub!=0 && (nums[i]-nums[i-1])/sub<0){
                dp[i] = dp[i-1] + 1;
            }
            else
                dp[i] = dp[i-1];
            sub = nums[i]-nums[i-1]==0?sub:(nums[i]-nums[i-1])/Math.abs(nums[i]-nums[i-1]);
        }
        return dp[nums.length-1];
    }
}
