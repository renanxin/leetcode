import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 18 删除链表的节点
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)
            return head;
        if(head.val==val)
            return head.next;
        ListNode tmp = head;
        while(head!=null && head.next!=null){
            if(head.next.val==val){
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return tmp;
    }
}
