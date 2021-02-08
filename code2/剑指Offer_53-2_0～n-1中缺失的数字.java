import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 53-2 0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length + 1; ++i)
            res ^= i;
        for (int num : nums)
            res ^= num;
        return res;
    }
}
