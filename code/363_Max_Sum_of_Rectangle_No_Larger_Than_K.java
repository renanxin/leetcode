import java.util.*;



class Solution{

    // solution for 363
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < rows; ++i)
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        for (int i = 1; i < cols; ++i)
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        for (int i = 1; i < rows; ++i)
            for (int j = 1; j < cols; ++j)
                dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                for (int t = 0; t <= i; ++t) {
                    for (int p = 0; p <= j; ++p) {
                        int tmp;
                        if (t == 0 && p == 0)
                            tmp = dp[i][j];
                        else if (t == 0)
                            tmp = dp[i][j] - dp[i][p - 1];
                        else if (p == 0)
                            tmp = dp[i][j] - dp[t-1][j];
                        else
                            tmp = dp[i][j] + dp[t-1][p-1] - dp[t-1][j] - dp[i][p-1];
                        if(tmp<=k)
                            res = Math.max(tmp,res);
                    }
                }
            }
        }
        return res;
    }
}
