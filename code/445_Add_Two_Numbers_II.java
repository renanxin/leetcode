import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 445
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_tmp = reverseLinkList(l1);
        ListNode l2_tmp = reverseLinkList(l2);
        ListNode head = new ListNode();
        int overflow = 0;
        while(l1_tmp!=null && l2_tmp!=null){
            int tmp = l1_tmp.val+overflow+l2_tmp.val;
            if(tmp>9){
                tmp-=10;
                overflow = 1;
            }else
                overflow = 0;
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
            l1_tmp = l1_tmp.next;
            l2_tmp = l2_tmp.next;
        }
        while(l1_tmp!=null){
            int tmp = l1_tmp.val+overflow;
            if(tmp>9){
                tmp-=10;
                overflow = 1;
            }else
                overflow = 0;
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
            l1_tmp = l1_tmp.next;
        }
        while(l2_tmp!=null){
            int tmp = l2_tmp.val+overflow;
            if(tmp>9){
                tmp-=10;
                overflow = 1;
            }else
                overflow = 0;
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
            l2_tmp = l2_tmp.next;
        }
        if(overflow==1){
            ListNode newNode = new ListNode(1);
            newNode.next = head.next;
            head.next = newNode;
        }
        return head.next;
    }
}
