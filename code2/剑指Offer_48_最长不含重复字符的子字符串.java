import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 48 最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int res = 1,tmp=0;
        int[] flag = new int[128];
        int begin = 0,end = 0;
        while(begin<s.length()){
            int index = s.charAt(begin);
            flag[index] += 1;
            tmp += 1;
            if(flag[index]>1){
                while(flag[index]>1){
                    flag[s.charAt(end)] -= 1;
                    tmp -= 1;
                    end += 1;
                }
            }
            res = res<tmp?tmp:res;
            begin +=1;
        }
        return res;
    }
}
