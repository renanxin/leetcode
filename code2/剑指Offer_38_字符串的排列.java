import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 38 字符串的排列
    public String[] permutation(String s) {
        HashSet<String> res = new HashSet<>();
        permutation(s.toCharArray(),res,0);
        return res.toArray(new String[0]);
    }

    public void permutation(char[] chars,HashSet<String> res,int index){
        if(index==chars.length-1)
            res.add(new String(chars));
        else{
            int[] tmpChar = new int[26];
            for(int i=index;i<chars.length;++i){
                if(tmpChar[chars[i]-'a']==1)
                    continue;
                tmpChar[chars[i]-'a']=1;
                char tmp = chars[i];
                chars[i] = chars[index];
                chars[index] = tmp;
                permutation(chars,res,index+1);
                chars[index] = chars[i];
                chars[i] = tmp;
            }
        }
    }
}
