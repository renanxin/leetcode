import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	此题的主要目标是对二叉树进行后序遍历
	
	与前序不同，后序的话无法遍历到某个节点的时候不能确定该节点是否需要出栈即它的左右子节点是否被遍历过了，
	这里解决的主要办法是利用pre变量存储上一个遍历的节点，这样就可以通过判断当前节点是否是pre的父节点来得
	是否需要将当前遍历节点出栈
	
	当然需要注意只有左节点的情况
*/

public class Solution {


    // solution for 145
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
		// 根节点为空的情况
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
			// 叶节点直接遍历并出栈
            if (top.left == null && top.right == null)
                res.add(top.val);
            else {
				// 当前遍历节点的子节点已经被遍历过了
                if (top.right == pre || top.left==pre && top.right==null) {
                    res.add(top.val);
                }
				// 将右节点、左节点依次放入栈中准备进行遍历
				else {
                    stack.push(top);
                    if (top.right != null)
                        stack.push(top.right);
                    if (top.left != null)
                        stack.push(top.left);
                }
            }
            pre = top;
        }
        return res;
    }
}
