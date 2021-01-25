import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 13 机器人的运动范围
    int moveCount = 0;
    public int movingCount(int m, int n, int k) {
        if(k==0)
            return 0;
        int[][] dp = new int[m][n];
        movingCountBFS(dp,0,0,k);
        return moveCount;
    }

    public void movingCountBFS(int[][] dp, int i, int j, int k){
        if(i<0 || i>=dp.length || j<0 || j>=dp[0].length)
            return;
        if(positionVal(i,j)>k)
            dp[i][j] = -1;
        if( dp[i][j] == 0 ){
            System.out.println(1);
            moveCount += 1;
            dp[i][j] = 1;

            // 为了提高时间效率，只需要向右和下进行递推
            movingCountBFS(dp,i+1,j,k);
            movingCountBFS(dp,i,j+1,k);
        }
    }

    public int positionVal(int i,int j){
        int res = 0;
        while(i!=0){
            res += (i%10);
            i/=10;
        }
        while(j!=0){
            res += (j%10);
            j/=10;
        }
        return res;
    }
}
