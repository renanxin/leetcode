/**
     * 这题是得到一个二叉树从根节点到叶子节点的所有路径，将结果存储在List中
     * 对于从根节点到叶子节点的路径，可以采用后序遍历，当遍历到一个叶子节点的时候，
     * 将栈tmp中的节点一次连接成字符串
*/

public class Solution {

    List<String> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null)
            postVisit(root);
        return res;
    }

    public void postVisit(TreeNode node){
        tmp.add(node.val);
        if(node.left==null&&node.right==null) {
            res.add(joinArray(tmp));

        }
        else{
            if(node.left!=null)
                postVisit(node.left);
            if(node.right!=null)
                postVisit(node.right);
        }
        tmp.remove(tmp.size()-1);
    }

    public String joinArray(List<Integer> array){
        StringBuilder s = new StringBuilder();
        s.append(array.get(0));
        for(int i=1;i<array.size();++i){
            s.append("->");
            s.append(array.get(i));
        }
        return s.toString();
    }
}
