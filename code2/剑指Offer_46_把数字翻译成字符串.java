import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 46 把数字翻译成字符串
    public int translateNum(int num) {
        String str = String.valueOf(num);
        if(str.length()==1)
            return 1;
        int[] dp = new int[str.length()+1];
        dp[0]=1;
        dp[1] = 1;
        if(str.charAt(0)=='1' || str.charAt(0)=='2' && str.charAt(1)<'6')
            dp[1]+=1;
        for(int i=1;i<str.length();++i){
            dp[i] = dp[i-1];
            if(str.charAt(i-1)=='1' || str.charAt(i-1)=='2' && str.charAt(i)<'6')
                dp[i]+=dp[i-2];
        }
        return dp[str.length()-1];
    }
}
