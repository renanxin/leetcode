import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 62 圆圈中最后剩下的数字
    int _sumNums = 0;
    public int sumNums(int n) {
        sumNumsDP(n);
        return _sumNums;
    }

    public boolean sumNumsDP(int n){
        _sumNums+=n;
        return n>0 && sumNumsDP(n-1);
    }
}
