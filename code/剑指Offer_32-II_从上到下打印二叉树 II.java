import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 32-II 从上到下打印二叉树 II
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
        nodes.addLast(root);
        while(!nodes.isEmpty()){
            List<Integer> listTmp = new ArrayList<>();
            while(!nodes.isEmpty()){
                TreeNode first = nodes.removeFirst();
                listTmp.add(first.val);
                if(first.left!=null)
                    tmp.addLast(first.left);
                if(first.right!=null)
                    tmp.addLast(first.right);
            }
            res.add(listTmp);
            nodes.addAll(tmp);
            tmp.clear();
        }
        return res;
    }
}
