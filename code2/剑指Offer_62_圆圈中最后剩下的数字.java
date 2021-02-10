import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 62 圆圈中最后剩下的数字
    public int lastRemaining(int n, int m) {
        return lastRemainingDP(n,m);
    }

    public int lastRemainingDP(int n, int m) {
        if(n==1)
            return 0;
        return (n+lastRemaining(n-1,m)+m)%n;
    }

    public int lastRemaining_better(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }
}
