/*
	直接俄使用队列对完全二叉树进行遍历，当然也可以使用递归，分别得到左子树和右子树的countNodes
*/

public class Solution {
	

   public int countNodes(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        if(root==null)  return res;
        while(!queue.isEmpty()){
            TreeNode tmp = queue.pop();
            res+=1;
            if(tmp.left!=null){
                queue.add(tmp.left);
                if(tmp.right!=null)
                    queue.add(tmp.right);
            }
        }
        return res;
    }
}
