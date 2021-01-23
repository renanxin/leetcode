import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 03
    public int findRepeatNumber(int[] nums) {
        boolean[] exists = new boolean[100000+1];
        for(int i=0;i<nums.length;++i){
            if(exists[nums[i]])
                return nums[i];
            exists[nums[i]] = true;

        }
        return -1;
    }

    // 原地置换
    public int findRepeatNumber_better(int[] nums){
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i){
                int j = i;
                while(nums[j]!=j){
                    if(nums[nums[j]]==nums[j])
                        return nums[j];
                    int tmp = nums[nums[j]];
                    nums[nums[j]] = nums[j];
                    j = tmp;
                }
            }
        }
        return -1;
    }
}
