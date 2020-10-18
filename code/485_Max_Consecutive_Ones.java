class Solution {
    // solution for 485
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0,tmp = 0,max = 0;
        while(index<nums.length){
            if(nums[index]==1)
                tmp +=1;
            else{
                max = tmp>max?tmp:max;
                tmp = 0;
            }
            index += 1;
        }
        return tmp>max?tmp:max;
    }
}