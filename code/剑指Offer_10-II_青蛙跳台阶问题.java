import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 10-2 青蛙跳台阶问题
    public int numWays(int n) {
        if(n==0)
            return 1;
        if(n<=2)
            return n;
        int a1 = 1, a2 = 2;
        for(int i=3;i<=n;++i){
            int tmp = (a1+a2)%1000000007;
            if(i%2==1)
                a1 = tmp;
            else
                a2 = tmp;
        }
        return n%2==1?a1:a2;
    }
}
