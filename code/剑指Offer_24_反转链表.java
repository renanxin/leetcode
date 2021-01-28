import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 24 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode node = new ListNode();
        while(head!=null){
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }
        return node.next;
    }
}
