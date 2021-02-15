import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 68-1 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(tmp.val!=p.val){
            stack.push(tmp);
            if(tmp.val>p.val)
                tmp = tmp.left;
            else
                tmp = tmp.right;
        }
        stack.push(tmp);
        TreeNode[] nodes1 = stack.toArray(new TreeNode[0]);

        stack.clear();
        tmp = root;
        while(tmp.val!=q.val){
            stack.push(tmp);
            if(tmp.val>q.val)
                tmp = tmp.left;
            else
                tmp = tmp.right;
        }
        stack.push(tmp);
        TreeNode[] nodes2 = stack.toArray(new TreeNode[0]);
        int index = 0;
        for(int i=0;i<nodes1.length;++i){
            if(i< nodes2.length && nodes1[i]==nodes2[i])
                index = i;
            else
                break;
        }
        return nodes1[index];
    }
}
