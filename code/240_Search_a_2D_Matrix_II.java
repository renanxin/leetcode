/*
    可以知道这个数组的规律是每一行和每一列都是按照数字大小递增的，所以我们可以从数组的右上角开始循环，判断当前数值和
    目标target的大小关系，相等直接返回true，如果列，则可以知道当前行的所有值都不满足条件，需要左移动，如果小于，则
    当前行的值都不满足，需要下移一行
*/

public class Solution {

   // solution for 240
   public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false;
    int row_num = matrix.length, col_num = matrix[0].length, row = 0, col = col_num;
    System.out.println(row_num+";"+col_num);
    while (row >= 0 && row < row_num && col >= 0 && col < col_num) {
        System.out.println(row+" "+col);
        if(matrix[row][col]==target)
            return true;
        else if(matrix[row][col]>target)
            col-=1;
        else
            row+=1;
    }
    return false;
}
}
