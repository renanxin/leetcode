import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 725
    public ListNode[] splitListToParts(ListNode root, int k) {
//        ListNode[] res = new ListNode[k];
//        ListNode[] resTmp = new ListNode[k];
//        ListNode tmp = root;
//        for(int i=0;i<k&&tmp!=null;++i){
//            res[i] = tmp;
//            resTmp[i] = tmp;
//            tmp = tmp.next;
//        }
//        int index = 0;
//        while(tmp!=null){
//            resTmp[index].next = tmp;
//            resTmp[index] = resTmp[index].next;
//            index = (index+1)%k;
//            tmp = tmp.next;
//        }
//        for(int i=0;i<k;++i){
//            if(resTmp[i]!=null){
//                resTmp[i].next = null;
//            }else
//                break;
//        }
//        return res;

        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode tmp = root,pre;
        while(tmp!=null){
            tmp = tmp.next;
            ++len;
        }
        int count,overflow = 0;
        if(len%k==0)
            count = len/k;
        else{
            count = len/k;
            overflow = len-k*count;
        }
        tmp = root;
        int index = 0;
        while(tmp!=null){
            res[index] = tmp;
            pre = tmp;
            int count_tmp = index<overflow?count+1:count;
            for(int i=0;i<count_tmp&&tmp!=null;++i){
                pre = tmp;
                tmp = tmp.next;
            }
            pre.next = null;
            ++index;
        }
        return res;
    }
}
