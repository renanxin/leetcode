import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 42 连续子数组的最大和
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (tmp < 0)
                tmp = 0;
            tmp += nums[i];
            res = Math.max(tmp, res);
        }
        return res;
    }
}
