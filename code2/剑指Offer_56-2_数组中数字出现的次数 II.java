import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 56-2  数组中数字出现的次数 II
    public int singleNumber(int[] nums) {
        int one=0,two=0;
        for(int num:nums){
            one = one^num & ~two;
            two = two^num & ~one;
        }
        return one;
    }
}
