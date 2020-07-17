/*
	相较于153题，这里允许数组中出现相同元素，因此在以往的判断中需要加上处理left,mid,right相等的情况
	容易判断当left和right处的值相等时，无法对这两个值进行更新，左右两个部分都有可能存在最小值，因此
	我们可以使用递归，对左右两部分都使用getMin方法，这里添加了start和end标记
	
*/

public class Solution {
	
   // solution for 154
    public int findMin_2(int[] nums) {
        int len = nums.length;
		// 数组长度为1或数组未经过反转
        if (len == 1 || nums[0] < nums[len - 1]) return nums[0];
        return getMin(nums,0,len-1);
    }

    public int getMin(int[] nums,int start,int end){
        if(start==end)  return nums[start];
        int mid = start + (end - start)/2;
        if(nums[start]==nums[end])
			//　对左右两部分分别进行迭代
            return Math.min(getMin(nums,start,mid),getMin(nums,mid+1,end));
        else if(nums[mid]>nums[end])
            return getMin(nums,mid+1,end);
        else
            return g
	}
}
