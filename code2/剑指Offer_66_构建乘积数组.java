import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 66 构建乘积数组
    public int[] constructArr(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] b = new int[a.length];
        int tmp = 1;
        stack.push(1);
        for(int i=a.length-1;i>0;--i){
            tmp *= a[i];
            stack.push(tmp);
        }
        int left = 1;
        for(int i=0;i<a.length;++i){
            b[i] = left*stack.pop();
            left *= a[i];
        }
        return b;
    }
}
