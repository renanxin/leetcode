import leetcode.ListNode;

import java.util.*;



class Solution{

    // solution for 04
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int row_begin = 0, row_end = matrix[0].length-1;
        int col_begin = 0, col_end = matrix.length-1;
        while(row_begin<=row_end && col_begin<=col_end){
            for(int i=row_begin,j=col_begin;i<=row_end&&i<matrix[0].length;++i){
                if(matrix[i][j]==target)
                    return true;
                if(matrix[i][j]>target){
                    row_end = i-1;
                    break;
                }
            }
            ++col_begin;
            for(int i=col_begin,j=row_begin;i<=col_end && i<matrix.length;++i){
                if(matrix[j][i]==target)
                    return true;
                else if(matrix[j][i]>target){
                    col_end = i-1;
                    break;
                }
            }
            ++row_begin;
        }
        return false;
    }

    // 从右上角开始寻早
    public boolean findNumberIn2DArray_better(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int i=0,j = matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                --j;
            else
                ++i;
        }
        return false;
    }
}
