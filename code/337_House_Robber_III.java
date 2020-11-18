import leetcode.TreeNode;

import java.util.*;



class Solution{

    // solution for 337
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int[] res = dpTree(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dpTree(TreeNode root){
        int[] dp = new int[2];
        if(root.left==null && root.right==null) {
            dp[1] = root.val;
            return dp;
        }
        if(root.left!=null){
            int[] left = dpTree(root.left);
            dp[0] += Math.max(left[0],left[1]);
            dp[1] += left[0];
        }
        if(root.right!=null){
            int[] right = dpTree(root.right);
            dp[0] += Math.max(right[0],right[1]);
            dp[1] += right[0];
        }
        dp[1]+=root.val;
        return dp;
    }
}
