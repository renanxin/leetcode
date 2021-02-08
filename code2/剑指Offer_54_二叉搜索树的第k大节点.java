import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 54 二叉搜索树的第k大节点
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            num += 1;
            if(num==k)
                return tmp.val;
            if(tmp.left!=null){
                TreeNode left = tmp.left;
                while(left!=null){
                    stack.push(left);
                    left = left.right;
                }
            }
        }
        return -1;
    }
}
