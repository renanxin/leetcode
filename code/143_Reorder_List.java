import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	本题的主要目标是将链表重新排列，排列的顺序是从头部和尾部依次取出节点拼接
	这里主要采用的方法是先顺序遍历得到链表的长度，然后可以得到目标链表中奇索引和偶索引的个数
	主要是通过除以2得到
	对于后半部分，其它新链表中的顺序是倒序的，所以可以直接将这部分链表反转
	最后就是将这两部分链表一次交替插入新的链表即可
*/

public class Solution {
    public static void main(String[] args) {

    }
    // solution for 143
    public void reorderList(ListNode head){
        long len = getListNodeLen(head);
        if(len>2){
            ListNode mid = head,tmp = head;
            long mid_index = len/2;
            for(int i=1;i<(len-mid_index);++i) {
                mid = mid.next;
            }
            tmp = mid.next;
            mid.next = null;
            mid = tmp;
            tmp = head;
            mid = reverseListNode(mid);
            ListNode left = head.next,right = mid;
            while(left!=null && right!=null){
                tmp.next = right;
                right = right.next;
                tmp = tmp.next;
                tmp.next = left;
                left = left.next;
                tmp = tmp.next;
            }
            if(right!=null){
                tmp.next = right;
                tmp = tmp.next;
            }

            tmp.next=null;
        }

    }

    // 获取链表的长度
    public long getListNodeLen(ListNode head){
        if(head==null)  return 0;
        ListNode pre = head;
        long i = 1L;
        while(pre.next!=null){
            ++i;
            pre = pre.next;
        }
        return i;
    }

    // 将链表反转
    public ListNode reverseListNode(ListNode head){
        if(head==null||head.next==null)     return head;
        ListNode next,top=null;
        while(head!=null){
            next = head.next;
            head.next=top;
            top = head;
            head = next;
        }
        return top;
    }
}
