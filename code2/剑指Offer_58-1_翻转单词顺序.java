import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 58-1 翻转单词顺序
    public String reverseWords(String s) {
        String[] spilts = s.split("\\ ");
        s = s.trim();
        if(s.length()<2)
            return s;
        StringBuilder builder = new StringBuilder();
        for(int i= spilts.length-1;i>=0;--i){
            if(spilts[i].length()==0)
                continue;
            builder.append(spilts[i]);
            builder.append(" ");
        }
        return builder.substring(0,builder.length()-1).toString();
    }
}
