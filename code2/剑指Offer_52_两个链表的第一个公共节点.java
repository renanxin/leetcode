import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 52 两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA,tmpB = headB;
        int len1 = 0, len2 = 0;
        while(tmpA!=null && tmpA.next!=null){
            ++len1;
            tmpA = tmpA.next;
        }

        while(tmpB!=null && tmpB.next!=null){
            ++len2;
            tmpB = tmpB.next;
        }
        if(tmpA==null || tmpB==null ||  tmpA!=tmpB)
            return null;
        while(len1>len2){
            headA=headA.next;
            --len1;
        }
        while(len1<len2){
            headB = headB.next;
            --len2;
        }
        while(headA!=headB){
            headA= headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
