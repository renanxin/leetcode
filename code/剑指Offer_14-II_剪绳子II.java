import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 14-2 剪绳子2
    public int cuttingRope_II(int n) {
        if(n<=3)
            return n-1;
        long res = 1;
        while(n>4){
            res *= 3;
            if(res>=1000000007)
                res %=  1000000007;
            n -= 3;
        }
        return (int)(res*n%1000000007);
    }
}
