import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 36 二叉搜索树与双向链表
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node head = root, tail = root, preNode;
        while (head.left != null)
            head = head.left;
        while (tail.right != null)
            tail = tail.right;
        Stack<Node> stack = new Stack<>();
        preNode = tail;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (true) {
            Node peak = stack.pop();
            preNode.right = peak;
            peak.left = preNode;
            preNode = peak;
            if (peak == tail)
                break;
            Node tmp = peak.right;
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return head;
    }
}
