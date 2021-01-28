import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 25 合并两个排序列表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(),pre = head;
        while(l1!=null && l2!=null){
            if(l2.val<l1.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if(l1!=null)
            pre.next = l1;
        else if(l2!=null)
            pre.next = l2;
        else
            pre.next = null;
        return head.next;
    }
}
