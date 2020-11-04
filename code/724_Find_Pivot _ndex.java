class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length<3)   return -1;
        int sum1 = 0,sum2 = 0;
        for(int i=1;i<nums.length;++i)
            sum2 += nums[i];
        int res = 0;
        while(res<nums.length){
            System.out.println(sum1+"    "+sum2);
            if(sum1==sum2)
                break;
            else{
                sum1 += nums[res];
                ++res;
                if(res<nums.length)
                    sum2 -= nums[res];
            }
        }
        return res==nums.length?-1:res;
    }
}