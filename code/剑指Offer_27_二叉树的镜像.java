import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 27 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        switchLeftAndRightChild(root);
        return root;
    }

    public void switchLeftAndRightChild(TreeNode root){
        if(root==null)
            return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if(root.left!=null)
            switchLeftAndRightChild (root.left);
        if(root.right!=null)
            switchLeftAndRightChild(root.right);
    }
}
