import java.util.*;

/**
 * 对于寻找这种连续子串，我们可以每次寻找从当前遍历点向前搜寻满足条件的个数，设置pvc表示子串开始位置，
 * 这是因为遇到了值大于R的，肯定不能满足，如果遇到介于L和R之间的值，从当前节点可以有i-pvc+1个满足条件的字串
 * 遇到小于的值，则至少需要包含往前介于L和R之间的值开始的序列，所以是pvc
 */
class Solution{

    // solution for 474
    // 可以参考0-1背包
    public int findMaxForm(String[] strs, int m, int n) {
        // 对于dp[i][j][k]的含义就是在前i个字符串中0不超过m个、1不超过n个时满足条件的子集个数
        int[][] dp =new int[m+1][n+1];
        for(int i=0;i<strs.length;++i){
            int count0 = 0,count1=0;
            for(int j=0;j<strs[i].length();++j){
                if(strs[i].charAt(j)=='0')
                    count0+=1;
                else
                    count1+=1;
            }
            for(int j=m;j>=count0;--j){
                for(int k=n;k>=count1;--k){
                    dp[j][k] = Math.max(dp[j][k],dp[j-count0][k-count1]+1);
                }
            }

            for(int p=0;p<=m;++p){
                for(int j=0;j<=n;++j)
                    System.out.print(dp[p][j]+" ");
                System.out.println();
            }

            System.out.println();
            System.out.println();
        }
        return dp[m][n];
    }
}
