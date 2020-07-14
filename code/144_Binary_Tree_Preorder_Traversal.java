import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	此题的主要目标是对二叉树进行前序遍历
	
	采用的主要方法是利用栈将需要遍历的节点依次存入，首先是将根节点入栈，之后进行循环，当栈不为空时
	取出栈顶元素，访问它，然后将它的右子树根节点和左子树根节点依次入栈
*/

public class Solution {


    // solution for 144
    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode tmp;
        Stack<TreeNode> tree = new Stack<>();
        if(root!=null)
            tree.push(root);
        while(!tree.isEmpty()){
            tmp = tree.pop();
            res.add(tmp.val);
            if(tmp.right!=null)
                tree.push(tmp.right);
            if(tmp.left!=null)
                tree.push(tmp.left);
        }
        return res;
    }
}
