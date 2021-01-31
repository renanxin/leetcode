import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 37 序列化二叉树
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "[]";
            TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);
            ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
            ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            nodes.addLast(root);
            int notNullNum = 1;
            while (notNullNum != 0) {
                notNullNum = 0;
                while (!nodes.isEmpty()) {
                    TreeNode node = nodes.removeFirst();
                    if (node == nullNode) {
                        builder.append("null");
                        builder.append(',');
                        continue;
                    }
                    builder.append(node.val);
                    builder.append(',');
                    if (node.left != null) {
                        tmp.addLast(node.left);
                        ++notNullNum;
                    } else
                        tmp.addLast(nullNode);
                    if (node.right != null) {
                        tmp.addLast(node.right);
                        ++notNullNum;
                    } else
                        tmp.addLast(nullNode);
                }
                if (notNullNum != 0) {
                    ArrayDeque<TreeNode> tmpQueue = nodes;
                    nodes = tmp;
                    tmp = tmpQueue;
                }
            }
            builder.setCharAt(builder.length() - 1, ']');
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodesStr = data.substring(1, data.length() - 1).split(",");
            if (nodesStr.length == 0 || data.equals("[]"))
                return null;
            ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
            ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
            TreeNode res = new TreeNode(Integer.valueOf(nodesStr[0]));
            int index = 1;
            nodes.addLast(res);
            while (!nodes.isEmpty() && index < nodesStr.length) {
                while (!nodes.isEmpty()) {
                    TreeNode node = nodes.removeFirst(), left, right;
                    if (nodesStr[index].equals("null"))
                        left = null;
                    else
                        left = new TreeNode(Integer.valueOf(nodesStr[index]));
                    index += 1;
                    if (nodesStr[index].equals("null"))
                        right = null;
                    else
                        right = new TreeNode(Integer.valueOf(nodesStr[index]));
                    index += 1;
                    node.left = left;
                    node.right = right;
                    if(left!=null)
                        tmp.addLast(left);
                    if(right!=null)
                        tmp.addLast(right);
                }
                ArrayDeque<TreeNode> tmpQueue = nodes;
                nodes = tmp;
                tmp = tmpQueue;
            }
            return res;
        }
    }
}
