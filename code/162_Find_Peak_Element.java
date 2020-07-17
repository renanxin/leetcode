/*
	此题是求数组的peak的index，即求比它周边数都大的元素索引
	首先注意到假定数组外侧的数为负无穷，那么数组中一定存在着peak，使用二分，对mid和mid+1进行判断，
	如果mid<mid+1，那么右侧绝对存在着peak，所以更新left，同理更新right，最后left与right相等时结束
	
*/

class MinStack {
	// solution for 162
    public int findPeakElement(int[] nums){
        int len = nums.length;
        int left=0,right=len-1,mid;
        while(left<right){
            mid = left + (right-left) / 2;
            if(nums[mid]<nums[mid+1])
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}
