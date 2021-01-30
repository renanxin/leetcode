import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 33 二叉搜索树的后序遍历序列
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length-1);
    }

    public boolean verifyPostorder(int[] postorder,int begin,int end){
        if(begin>=end-1)
            return true;
        int index = begin;
        for(;index<end;++index){
            if(postorder[index]>end)
                break;
        }
        int tmp = index;
        while(tmp<end){
            if(postorder[tmp]<postorder[end])
                return false;
            tmp ++;
        }
        if(index>0)
            return verifyPostorder(postorder,begin,index-1) && verifyPostorder(postorder,index,end-1);
        else
            return verifyPostorder(postorder,index,end-1);
    }
}
