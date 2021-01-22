import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 237
    public void deleteNode(ListNode node) {
        if(node.next==null)
            node = null;
        else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
