import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 22 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp1 = head, tmp2 = head;
        for(int i=1;i<k&&tmp1!=null;++i){
            tmp1 = tmp1.next;
        }
        while(tmp1.next!=null){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return tmp2;
    }
}
