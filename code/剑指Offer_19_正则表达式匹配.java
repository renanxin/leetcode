import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 19 正则表达式匹配
    public boolean isMatch(String s, String p) {
        return isMatchDP(s,p,0,0);
    }

    public boolean isMatchDP(String s,String p,int indexS,int indexP){

        if(indexS==s.length()&& indexP==p.length())
            return true;
        if(indexP<0||indexS>=s.length()||indexP>=p.length()){
            if(indexS==s.length()){
                if(p.charAt(indexP)=='*')
                    return isMatchDP(s,p,indexS,indexP+1);
                if(indexP<p.length()-1){
                    if(p.charAt(indexP+1)=='*')
                        return isMatchDP(s,p,indexS,indexP+2);

                }

            }
            return false;
        }

        if(s.charAt(indexS) == p.charAt(indexP)||p.charAt(indexP)=='.'){
            if(indexP<p.length()-1 && p.charAt(indexP+1)=='*')
                return isMatchDP(s,p,indexS+1,indexP+1)||isMatchDP(s,p,indexS,indexP+2);
            return isMatchDP(s,p,indexS+1,indexP+1);
        }
        if(p.charAt(indexP)=='*'){
            if(indexP>0 && (p.charAt(indexP-1)==s.charAt(indexS)||p.charAt(indexP-1)=='.'))
                return isMatchDP(s,p,indexS+1,indexP) || isMatchDP(s,p,indexS+1,indexP+1)||isMatchDP(s,p,indexS,indexP+1);
            else
                return isMatchDP(s,p,indexS,indexP+1);
        }
        if(indexP<p.length()-1 && p.charAt(indexP+1)=='*')
            return isMatchDP(s,p,indexS,indexP+2);
        return false;
    }
}
