import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 39 数组中出现次数超过一半的数字
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (res != nums[i]) {
                if (count > 0)
                    --count;
                else {
                    res = nums[i];
                    count = 1;
                }
            } else {
                ++count;
            }
        }
        return res;
    }
}
