class Solution {
    // solution for leetcode 674
    public int findLengthOfLCIS(int[] nums) {
        int len = 0, index = 0;
        for(int i=1;i<nums.length;++i){
            if(nums[i]<=nums[i-1]){
                if(i-index > len)
                    len = i-index;
                index = i;
            }
        }
        if(nums.length-index > len)
            len = nums.length-index;
        return len;
    }
}