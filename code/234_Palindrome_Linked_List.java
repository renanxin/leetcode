import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 234
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        len = (len+1)/2;
        tmp = head;
        for(int i=0;i<len;++i)
            tmp = tmp.next;
        ListNode head2 = reverseLinkList(tmp);
        System.out.println(head2.val);
        while(head2!=null && head!=null){
            if(head.val!=head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
