import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 44 数字序列中某一位的数字
    public static int findNthDigit(int n) {
        if(n<10)
            return n;
        long tmp = 189,pre = 9;
        int num = 2;
        while(tmp<n){
            pre = tmp;
            tmp = (long) (tmp+Math.pow(10,num)*9*(num+1));
            num += 1;
        }
        int val = (int) ((n-pre-1)/num);
        pre += val*num;
        if(pre==n){
            int tmpVal = (int) (Math.pow(10,num)+val-1);
            return tmpVal%10;
        }else{
            int tmpVal = (int) (Math.pow(10,num-1)+val);
            return Integer.valueOf(String.valueOf(tmpVal).charAt((int) (n-pre-1))-'0');
        }
    }
}
