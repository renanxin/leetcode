import java.util.*;



class Solution{

    // solution for 516
    public int longestPalindromeSubseq(String s) {
        StringBuilder builder = new StringBuilder(s);
        return longestPalindromeSubseq_dp(s,builder.reverse().toString());
    }

    public int longestPalindromeSubseq_dp(String s1,String s2) {
        int m = s1.length(),n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
