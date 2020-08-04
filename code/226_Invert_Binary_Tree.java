/*
	此题的目标是将二叉树每一层的左右子树发转，我们可以使用递归，如果当前节点不为null，则依次将其左右子树进行相同的操作
	然后再利用中间变量tmp将其左右子节点互换
*/

public class Solution {
	

   // solution for 226
    public TreeNode invertTree(TreeNode root) {
        swapTreeNode(root);
        return root;
    }

    public void swapTreeNode(TreeNode root) {
        if (root == null) return;
        swapTreeNode(root.left);
        swapTreeNode(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
