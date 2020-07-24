/*
	本题的目标是求两个链表的公共节点
	首先获取两个链表的长度，从头开始遍历将较长的那个链表长度变得和较短的那个相等
	之后将这两个链表同时遍历并做比较，直到二者被遍历到的节点相等或是为null才返回
	
*/

public class Solution {

        public long getListNodeLen(ListNode head) {
        if (head == null) return 0;
        ListNode pre = head;
        long i = 1L;
        while (pre.next != null) {
            ++i;
            pre = pre.next;
        }
        return i;
    }
    
   // solution for 160
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        long len_A = getListNodeLen(headA);
        long len_B = getListNodeLen(headB);
        if(len_A>len_B){
            while (len_A > len_B) {
                len_A -= 1;
                headA = headA.next;
            }
        }
        else if(len_A<len_B){
            while(len_A<len_B) {
                len_B -= 1;
                headB = headB.next;
            }
        }
        while(headA!=null&&headB!=null&&headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
