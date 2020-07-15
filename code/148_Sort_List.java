import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	此题的主要目标是在快排的时间复杂度中将链表排序
	
	首先想到快排是一种递归模式，子问题的长度从1 ->  2  ->  4  ->  8  ->  16
	而单向链表是无法递归的
	所以只能使用循环
	设置一个i表示当前子问题集的长度，当它小于链表长度时
	每次先后取i长度的部分链表，将他们按照大小顺序合并起来并插到之前链表的尾部
	需要注意的是这两段链表的长度不足i和只有第一个链表的情况
*/

public class Solution {


    // 获取链表的长度
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
    
    // 将两个链表按照节点大小顺序连接起来，并且将最后一个节点返回
    public ListNode listNodeJoin(ListNode base,ListNode join1,ListNode join2){
        ListNode tmp = null;
        while(join1!=null && join2!=null){
            if(join1.val<join2.val){
                base.next = join1;
                join1 = join1.next;
            }else{
                base.next = join2;
                join2 = join2.next;
            }
            base = base.next;
            tmp = base;
        }
        while(join1!=null){
            base.next = join1;
            join1 = join1.next;
            base = base.next;
            tmp = base;
        }
        while(join2!=null){
            base.next = join2;
            join2 = join2.next;
            base = base.next;
            tmp = base;
        }
        return tmp;
    }


   // solution for 148
    public ListNode sortList(ListNode head) {
		// first是自定义个链表头，便于之后的处理，base则是用于存储每次处理过程中的链表尾部，用于将合并之后
		// 之后的链表拼接在它之后
        ListNode first = new ListNode(),pre = head,join1,join2,tmp,base=first;
        long len = getListNodeLen(head);
        if(len<2)   return head;
        int i=1,j=1;
		// 子问题集的长度小于初始链表的长度
        while(i<len){
            while(true){
                join1 = pre;
				// 取得第一段链表
                for(;j<=i && pre!=null;++j) {
                    if(j==i){
                        tmp = pre;
                        pre = pre.next;
                        tmp.next = null;
                    }else
                        pre = pre.next;
                }
				// 只有一段链表的情况
                if(pre==null) {
                    base.next = join1;
                    break;
                }
                join2 = pre;
                j = 1;
				// 取得第二段链表
                for(;j<=i && pre!=null;++j) {
                    if(j==i){
                        tmp = pre;
                        pre = pre.next;
                        tmp.next = null;
                    }else
                        pre = pre.next;
                }
				// 将这两个链表合并并拼接在base之后，同时返回拼接之后链表的最后一个节点用于更新base
                base = listNodeJoin(base,join1,join2);
                j=1;
            }
			// 重新对一些数据初始化
            base = first;
            i = i*2;
            j = 1;
            pre = first.next;
        }
        return first.next;
    }
}
