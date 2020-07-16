import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	本题是从一个数组中寻找最小值，不过这个是有一个排好序的数组从某一处折叠而得到的
	可以采用二分法，定义left和right，当二者之差大于1时，之所以大于1，因为等于1的时候可能在后续的判断中出现死循环
	得到left和right的二分mid，当mid处值大于left，表明最小值应该出现在mid和right之间，重新设置left，反之也类似处理
*/

public class Solution {
	// solution for 153
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1 || nums[0] < nums[len - 1]) return nums[0];
        int left = 0, right = len - 1;
        while(right-left>1){
            int mid = (left+right)/2;
            if(nums[mid]>nums[right])
                left = mid;
            else
                right = mid;
        }
        return Math.min(nums[left],nums[right]);
    }
}
