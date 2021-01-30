import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 32-I 从上到下打印二叉树
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode first = deque.removeFirst();
            res.add(first.val);
            if(first.left!=null)
                deque.addLast(first.left);
            if(first.right!=null)
                deque.addLast(first.right);
        }
        return res.stream().mapToInt((val)->(int)val).toArray();
    }
}
