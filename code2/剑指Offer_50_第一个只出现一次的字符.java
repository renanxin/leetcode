import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 50 第一个只出现一次的字符
    public char firstUniqChar(String s) {
        int[][] flags = new int[200][2];
        for (int i = 0; i < s.length(); ++i) {
            char tmp = s.charAt(i);
            flags[tmp][1] += 1;
            if (flags[tmp][1] == 1) {
                flags[tmp][0] = i;
            }
        }
        char res = ' ';
        int order = Integer.MAX_VALUE;
        for (int i = 0; i < 200; ++i) {
            if (flags[i][1] == 1) {
                if (order > flags[i][0]) {
                    order = flags[i][0];
                    res = (char) i;
                }
            }
        }
        return res;
    }
}
