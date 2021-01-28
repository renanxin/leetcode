import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 26 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        if(A!=null)
            treeNodes.addLast(A);
        while(!treeNodes.isEmpty()){
            TreeNode first = treeNodes.removeFirst();
            if(first.left!=null){
                treeNodes.addLast(first.left);
            }
            if(first.right!=null){
                treeNodes.addLast(first.right);
            }
            if(first.val==B.val)
                if(isSubStructureDP(first,B))
                    return true;
        }
        return false;
    }

    public boolean isSubStructureDP(TreeNode A,TreeNode B){
        if(A==null && B==null)
            return true;
        if(A==null || B==null)
            return true;
        if(A.val==B.val){
            return isSubStructure(A.left,B.left) && isSubStructure(A.right,B.right);
        }
        return false;
    }
}
