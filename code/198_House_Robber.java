/*
	此题的目标是给定一组相邻房子中的金额数组，抢劫犯只能抢劫不相邻的房子，求可以抢到的金额最大值
	对于第i的房间，此处的最大值为前面房子与再前面房子加当前房子金额的最大值，即dp[i] = max(dp[i-1],dp[i-2]+nums[i])
	
*/

class MinStack {

   // solution for 198
    public int rob(int[] nums){
        if(nums.length==0)  return 0;
        if(nums.length==1)  return nums[0];
        if(nums.length==2)  return nums[0]>nums[1]?nums[0]:nums[1];
        int a = nums[0], b = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;++i){
            int tmp = b;
            b = Math.max(a+nums[i],b);
            a = b;
        }
        return b;
    }
}
