import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 328
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode odd = head,even = odd.next,tmp = even.next;
        ListNode odd_tmp = odd,even_tmp = even;
        boolean flag = true;
        while(tmp!=null){
            if (flag){
                odd_tmp.next = tmp;
                tmp = tmp.next;
                odd_tmp = odd_tmp.next;
            }else{
                even_tmp.next = tmp;
                tmp = tmp.next;
                even_tmp = even_tmp.next;
            }
            flag = !flag;
        }
        odd_tmp.next = even;
        even_tmp.next = null;
        return odd;
    }
}
