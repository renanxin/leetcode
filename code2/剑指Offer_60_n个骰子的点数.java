import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 60 n个骰子的点数
    public double[] dicesProbability(int n) {
        double[] res = new double[5*n+1];
        double[] dp = new double[67];
        double possible = 1d/6;
        for(int i=1;i<7;++i)
            dp[i] = possible;
        for(int i=1;i<n;++i){
            double[] tmp = new double[67];
            for(int j=i;j<=6*i;++j){
                for(int k=1;k<7;++k)
                    tmp[j+k] += dp[j] * possible;
            }
            dp = tmp;
        }
        int index = 0;
        for(int i=n;i<=6*n;++i)
            res[index++] = dp[i];
        return res;
    }
}
