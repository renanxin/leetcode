import java.util.*;



class Solution{

    // solution for 467
    public int findSubstringInWraproundString(String p) {
        if(p.length()==1)
            return 1;
        int[] dp = new int[26];
        int count = 0;
        for(int i=0;i<p.length();++i){
            int tmp=i;
            while(tmp>=0){
                if(tmp==i){
                    if(dp[p.charAt(tmp)-'a']==0){
                        dp[p.charAt(tmp)-'a']+=1;
                        count += 1;
                    }
                }else{
                    if(p.charAt(tmp)-p.charAt(tmp+1)==-1 || p.charAt(tmp)=='z' && p.charAt(tmp+1)=='a'){
                        if(dp[p.charAt(i)-'a']<(i-tmp+1)){
                            dp[p.charAt(i)-'a']+=1;
                            count += 1;
                        }
                    }else
                        break;
                }
                --tmp;
            }
        }
        return count;
    }
}
