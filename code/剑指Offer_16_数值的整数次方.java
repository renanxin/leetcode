import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 16 数值的整数次方
    public double myPow(double x, int n) {
        if(n==Integer.MIN_VALUE)
            System.out.println(n);
        double res = 1.0;
        if(n==0)
            return 1;
        int flag = 1;
        if(n<0){
            flag = -1;
            n *= -1;
        }
        while(n>0){
            if(n%2==1)
                res *= x;
            x*=x;
            n>>=1;
        }
        return flag==1?res:1/res;
    }
}
