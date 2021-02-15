import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 68-2 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        TreeNode[] nodes1= new TreeNode[0],nodes2= new TreeNode[0];
        TreeNode pre=null;
        while(!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            if(tmp.val == p.val){
                nodes1 = stack.toArray(new TreeNode[0]);
            }
            if(tmp.val == q.val){
                nodes2 = stack.toArray(new TreeNode[0]);
            }
            if(nodes1.length>0 && nodes2.length>0)
                break;
            if(tmp.right==null || tmp.right==pre){
                pre = stack.pop();
            }else{
                tmp = tmp.right;
                while(tmp!=null){
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }

        }
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
