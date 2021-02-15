import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 62 圆圈中最后剩下的数字
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int minVal = prices[0], res = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;++i){
            if(prices[i]<minVal)
                minVal = prices[i];
            res = Math.max(prices[i]-minVal,res);
        }
        return res;
    }
}
