import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 47 礼物的最大价值
    public int maxValue(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid[0].length;++i){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<grid.length;++i){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<dp.length;++i){
            for(int j=1;j<dp[0].length;++j){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
