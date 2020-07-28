/*
	此题的目标是如果存在两个及以上相同数，返回true，如果存在两个及以上的数字，那么对数组进行排序，则
	会出现相邻的数相等的情况，此时可以直接返回true
*/

public class Solution {
	
       // solution for 217
    public boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;++i){
            if(nums[i]==nums[i-1])
                return true;
        }
        return false;
    }
}
