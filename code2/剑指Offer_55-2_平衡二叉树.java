import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 55-2 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return isBalancedDB(root)!=-1;
    }


    public int isBalancedDB(TreeNode root){
        if(root==null)
            return 0;
        int left = isBalancedDB(root.left);
        if(left==-1)
            return -1;
        int right = isBalancedDB(root.right);
        if(right==-1)
            return -1;
        if(Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
