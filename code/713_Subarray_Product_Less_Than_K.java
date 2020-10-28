class Solution {
    // solution for 695
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int tmp = 1,left=-1,res=0;
        for(int i=0;i<nums.length && left<nums.length;++i){
            tmp *= nums[i];
            while(tmp>=k) {
                tmp /= nums[++left];
            }
            res += (i-left);
        }
        return res;
    }
}