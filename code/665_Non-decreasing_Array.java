class Solution {

    // solution for 665
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3)
            return true;
        boolean flag = false;   // 是否出现过两次下降
        for(int i=0;i<nums.length-1;++i){
            if(nums[i]>nums[i+1]){
                if(flag)
                    return false;
                else{
                    flag = true;
                    if(i==nums.length-2)
                        return true;
                    else{
                        if(nums[i]<=nums[i+2])
                            nums[i+1] = nums[i];
                        else if(i>0 && nums[i-1]<=nums[i+1] || i==0)
                            nums[i] = nums[i+1];
                        else
                            return false;
                    }
                }
            }
        }
        return true;
    }
}