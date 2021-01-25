import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 14-1 剪绳子
    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;
        int res = 1;
        while(n>4){
            res *= 3;
            n -= 3;
        }
        return res *= n;
    }
}
