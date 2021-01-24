import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 07 重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0)
            return null;
        Map<Integer, Integer> quickSearch = new HashMap<>();
        for(int i=0;i<inorder.length;++i)
            quickSearch.put(inorder[i],i);
        return reBuildBinaryTree(preorder,quickSearch,0,preorder.length-1,0,preorder.length-1);
    }

    public TreeNode reBuildBinaryTree(int[] preOrder,Map<Integer,Integer> quickSearch,int begin1,int end1,
                                      int begin2,int end2){
        if(begin1>end1)
            return null;
        TreeNode root = new TreeNode(preOrder[begin1]);
        if(begin1==end1){
            return root;
        }
        int index = quickSearch.get(preOrder[begin1]);
        root.left = reBuildBinaryTree(preOrder,quickSearch,begin1+1,begin1+index-begin2,begin2,index-1);
        root.right = reBuildBinaryTree(preOrder,quickSearch,begin1+index-begin2+1,end1,index+1,end2);
        return root;

    }
}
