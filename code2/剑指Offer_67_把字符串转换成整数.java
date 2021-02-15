import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 67 把字符串转换成整数
    public int strToInt(String str) {
        String simStr = str.trim();
        Long tmp = 0L;
        int flag = 0;
        for(int i=0;i<simStr.length();++i){
            if(simStr.charAt(i)=='+'){
                if(flag!=0)
                    return (int) (tmp*flag);
                flag = 1;
            }
            else if(simStr.charAt(i)=='+'){
                if(flag!=0)
                    return (int) (tmp*flag);
                flag = -1;
            }
            else if(simStr.charAt(i)>=0 && simStr.charAt(i)<='9' ){
                tmp = tmp*10+simStr.charAt(i)-'0';
                if(flag>=0){
                    if(tmp>=Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                }else{
                    if(tmp<=Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }
            }
            else
                break;
        }
        if(flag==0)
            flag = 1;
        return flag*tmp.intValue();
    }
}
