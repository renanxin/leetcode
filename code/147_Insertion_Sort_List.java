import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	此题的主要目标是对一个链表进行排序
	
	首先为了后续操作的遍历，可以为头节点添加一个无值的表头节点
	从head开始遍历，判断当前节点和next节点的大小，如果当前节点的值小，表示满足递增要求，则遍历下一个节点
	如果当前节点的值大，则需要将next的节点从表头节点开始遍历，将其插入到前面
	当当前节点的next为null便可以结束，返回值为表头节点的next节点
*/

public class Solution {


    // solution for 147
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode first = new ListNode();
        first.next = head;
        ListNode pre = first.next,tmp,item;
        while(pre.next!=null){
            System.out.println(pre.val);
            if(pre.val<pre.next.val) {
                pre = pre.next;
                continue;
            }
            tmp = pre.next;
            pre.next = tmp.next;
            item = first;
            while(item.next.val<tmp.val)
                item = item.next;
            tmp.next = item.next;
            item.next = tmp;
        }
        return first.next;
    }
}
