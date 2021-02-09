import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 58-2 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(n));
        builder.append(s.substring(0,n));
        return builder.toString();
    }
}
