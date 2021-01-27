import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 17 打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10,n)-1];
        for(int i=0;i<res.length;++i)
            res[i] = i+1;
        return res;
    }
}
