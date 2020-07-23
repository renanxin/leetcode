/*
	此题的目标就是假设你站在一棵二叉树的右侧向左看时，从树根到底部依次可以看到的节点值
	可以使用队列进行层次遍历，每次取出每层的最后一个元素，当然，对于队列的选择，对于最后
	结果的影响很大，推荐使用LinkedList
	
*/

class MinStack {
	// solution for 199
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)  return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int num = 1,num_tmp = 0;
        TreeNode  tmp=null;
        queue.add(root);
        while(!queue.isEmpty()){
            while(num>0){
                tmp = queue.peek();
                queue.remove();
                if(tmp.left!=null)  {
                    queue.add(tmp.left);
                    ++num_tmp;
                }
                if(tmp.right!=null)  {
                    queue.add(tmp.right);
                    ++num_tmp;
                }
                --num;
            }
            num = num_tmp;
            num_tmp = 0;
            res.add(tmp.val);
        }
        return res;
    }
}
