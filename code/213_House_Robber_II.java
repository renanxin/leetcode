/*
	相比与之前那道盗贼题，这里多了房子是环型的条件，所以到最后一个房子的时候，可能还因为之前的最大值是通过
	盗取第一个房子得到的，所以这里又新增了一组变量，表示当前不抢劫第一个房子的昨天和前天的最大金额。
*/

public class Solution {
	
   // solution for 213
    public int rob(int[] nums){
        if(nums==null||nums.length==0)  return 0;
        if(nums.length==1)  return nums[0];

        // 解决nums是环的问题，包含第一个房子和不包含
        int yesterdayWithFirst = nums[0]>nums[1]?nums[0]:nums[1];
        int twoDaysBackWithFirst = nums[0];
        int yesterdayWithoutFirst = nums[1];
        int twoDaysBackWithoutFirst = 0;

        for(int i = 2;i<nums.length-1;++i){
            int tmpWithFirst = yesterdayWithFirst,tmpWithOutFirst = yesterdayWithoutFirst;
            yesterdayWithFirst = (nums[i]+twoDaysBackWithFirst)>yesterdayWithFirst?(nums[i]+twoDaysBackWithFirst):yesterdayWithFirst;
            yesterdayWithoutFirst = (nums[i]+twoDaysBackWithoutFirst)>yesterdayWithoutFirst?(nums[i]+twoDaysBackWithoutFirst):yesterdayWithoutFirst;
            twoDaysBackWithFirst = tmpWithFirst;
            twoDaysBackWithoutFirst = tmpWithOutFirst;
        }
        yesterdayWithoutFirst = (nums[nums.length-1]+twoDaysBackWithoutFirst)>yesterdayWithoutFirst?(nums[nums.length-1]+twoDaysBackWithoutFirst):yesterdayWithoutFirst;
        return yesterdayWithFirst>yesterdayWithoutFirst?yesterdayWithFirst:yesterdayWithoutFirst;
    }
}
