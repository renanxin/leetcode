import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 21 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        int begin = 0, tmp =0;
        while(tmp<nums.length){
            if(nums[tmp]%2==1){
                int tmpVal = nums[tmp];
                nums[tmp] = nums[begin];
                nums[begin++] = tmpVal;
            }
            tmp++;
        }
        return nums;
    }
}
