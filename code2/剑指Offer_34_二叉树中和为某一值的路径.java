import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 34 二叉树中和为某一值的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        ArrayList<Integer> tmpVal = new ArrayList<>();
        pathSum(root,tmpVal,0,sum,res);
        return res;
    }

    public void pathSum(TreeNode root,List<Integer> tmpVal,int tmp, int sum,List<List<Integer>> res){
        if(root.left==null && root.right==null){
            if(tmp+root.val==sum){
                tmpVal.add(root.val);
                ArrayList<Integer> vals = new ArrayList<>(tmpVal);
                res.add(vals);
                int len = tmpVal.size();
                tmpVal.remove(len-1);
            }
            return;
        }
        tmpVal.add(root.val);
        if(root.left!=null)
            pathSum(root.left,tmpVal,tmp+root.val,sum,res);
        if(root.right!=null)
            pathSum(root.right,tmpVal,tmp+root.val,sum,res);
        int len = tmpVal.size();
        tmpVal.remove(len-1);
    }
}
