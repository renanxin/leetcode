import java.util.*;



class Solution{

    // solution for 392
    public boolean isSubsequence(String s, String t) {
        if(s.length()<0 || t.length()<=0&&s.length()!=0)
            return false;
        if(s.length()==0)
            return true;
        int len = s.length()-1,index=0;
        char next = s.charAt(index);
        for(char c:t.toCharArray()){
            if(len>=0 && next==c){
                --len;
                ++index;
                if(index<s.length())
                    next = s.charAt(index);
            }
        }
        return len==-1;
    }
}
