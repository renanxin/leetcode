/*
	为了删除操作的简便，通用性好，可以为这个链表添加一个头节点root，这样删除操作就可以同一，不用
	分太多的情况讨论
	
*/

class MinStack {
	
   // solution for 203
    public ListNode removeElements(ListNode head,int val){
        if(head==null)  return null;
        ListNode node = new ListNode(),root;
        node.next = head;
        root = node;
        while(root.next!=null){
            if(root.next.val==val)
                root.next = root.next.next;
            else
                root = root.next;
        }
        return node.next;
    }
}
