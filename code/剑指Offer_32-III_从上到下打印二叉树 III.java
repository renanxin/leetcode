import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 32-III 从上到下打印二叉树 III
    public List<List<Integer>> levelOrder3(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
        nodes.addLast(root);
        int order = 1;
        while(!nodes.isEmpty()){
            List<Integer> listTmp = new ArrayList<>();
            while(!nodes.isEmpty()){
                TreeNode first;
                if(order==1)
                    first = nodes.removeFirst();
                else
                    first = nodes.removeLast();
                if(order==1){
                    if(first.left!=null)
                        tmp.addLast(first.left);
                    if(first.right!=null)
                        tmp.addLast(first.right);
                }else{
                    if(first.right!=null)
                        tmp.addFirst(first.right);
                    if(first.left!=null)
                        tmp.addFirst(first.left);
                }
                listTmp.add(first.val);
            }
            res.add(listTmp);
            ArrayDeque pre = nodes;
            nodes = tmp;
            tmp = pre;
            order = 1 - order;
        }
        return res;
    }
}
