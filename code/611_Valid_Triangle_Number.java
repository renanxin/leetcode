class Solution {

    // solution for 611
    // 普通循环版本
    public int triangleNumber(int[] nums) {
        if(nums.length<3)   return 0;
        Arrays.sort(nums);
        int first=0,second=1,third=2,res=0;
        while(first<nums.length-2){
            second = first+1;
            while(second<nums.length-1){
                third = second+1;
                while(third<nums.length){
                    if(nums[first]+nums[second]>nums[third])
                        ++res;
                    else
                        break;
                    ++third;
                }
                ++second;
            }
            ++first;
        }
        return res;
    }

    // 二叉搜索版本
    public int triangleNumber_withBinary(int[] nums) {
        if(nums.length<3)   return 0;
        Arrays.sort(nums);
        int first=0,res=0;
        while(first<nums.length-2){
            int second = first+1;
            while(second<nums.length-1){

                int left = second+1,right = nums.length-1,sum = nums[first]+nums[second];
                while(left<right-1){
                    int mid = left + (left+right)/2;
                    if(nums[mid]>=sum)   right = mid-1;
                    else    left = mid;
                }
                if(nums[right]<sum)
                    res += (right-second);
                else if (nums[left] < sum) {
                    res += (left - second);
                }
                ++second;
            }
            ++first;
        }
        return res;
    }
}