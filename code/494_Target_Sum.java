import java.util.*;



class Solution{

    // solution for 494
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays_dp(nums,0,0,S);
    }

    public int findTargetSumWays_dp(int nums[],int index,int sum,int target){
        if(index==nums.length){
            if(target==sum)
                return 1;
            return 0;
        }
        return findTargetSumWays_dp(nums,index+1,sum+nums[index],target)+findTargetSumWays_dp(nums,index+1,sum-nums[index],target);
    }
}
