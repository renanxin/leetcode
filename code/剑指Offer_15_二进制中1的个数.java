import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 15 二进制中1的个数
    public int hammingWeight(int n) {
        int res = 0,flag=0;
        if(n<0)
            n = n-Integer.MIN_VALUE;
        while(n>0){
            System.out.println(n);
            res += n%2;
            n >>= 2;
        }
        return res;
    }
}
