/*
	此题的目标就是二叉搜索树的中序遍历
	首先自定义一个入栈函数，将入栈元素及其左子树依次入栈
	出栈的话先出栈，之后判断受否有右子树，有的话利用上面自定义的入栈函数将其入栈，最后返回结果即可
	
*/

public class Solution {

    // solution for 173
    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<TreeNode>();
        public BSTIterator(TreeNode root) {
            pushIntoStack(root);
        }

        /** @return the next smallest number */
        public int next() {
            if(hasNext()){
                TreeNode node = stack.pop();
                if(node.right!=null)
                    pushIntoStack(node.right);
                return node.val;
            }
            return -1;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // push a node into stack
        public void pushIntoStack(TreeNode node){
            TreeNode tmp = node;
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
    }
}
