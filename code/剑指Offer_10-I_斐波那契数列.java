import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 10-1 斐波那契数列
    public int fib(int n) {
        int mod = 1000000007;
        if(n<2)
            return n;
        int a1 = 0, a2 = 1;
        for(int i=2;i<=n;++i){
            int tmp = (a1+a2)%mod;
            if(i%2==0)
                a1 = tmp;
            else
                a2 = tmp;
        }
        return n%2==0?a1:a2;
    }
}
