import leetcode.ListNode;

import java.util.*;



class Solution{

    // 从尾到头打印列表
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int len = res.length-1;
        for(int i=res.length-1;i>=0;--i)
            res[len-i] = list.get(i);
        return res;
    }
}
