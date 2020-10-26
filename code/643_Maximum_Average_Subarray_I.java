class Solution {

    // solution for 643
    public double findMaxAverage(int[] nums, int k) {
        double res=0,max=0;
        for(int i=0;i<k;++i)
            res += nums[i];
        max = res;
        int j = 0;
        for(int i=k;i<nums.length;++i,++j){
            res = res-nums[j]+nums[i];
            if(max<res)
                max = res;
            
        }
        return max/k;
    }
}