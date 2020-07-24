/*
	本题的目标是将字符串反转，可以先这是一个头节点node，然后通过遍历head链表，通过头插法将链表
	反向插入到node之后，最终返回node.next即可，需要注意head为null或只有一个节点的情况
	
*/

public class Solution {
	
   // solution for 206
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode node = new ListNode(),root,tmp=head,next;
        node.next=null;
        root = node;
        while(tmp!=null){
            next = tmp.next;
            tmp.next = node.next;
            node.next = tmp;
            tmp = next;
        }
        return node.next;
    }
}
