import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 1721
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmp = head;
        for(int i=0;i<k-1&&tmp!=null;++i){
            tmp = tmp.next;
        }
        if(tmp==null)
            return head;
        ListNode first = tmp, tmp2 = head;
        while(tmp.next!=null){
            tmp2 = tmp2.next;
            tmp = tmp.next;
        }
        int tmpVal = first.val;
        first.val = tmp2.val;
        tmp2.val = tmpVal;
        return head;
    }
}
