import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 12 矩阵中的路径
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return true;
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(board[i][j] == word.charAt(0)){
                    if(existPath(board,word,i,j,0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean existPath(char[][] board, String word,int i, int j, int index){
        // 坐标不符合要求
        if(i<0 || i>=board.length || j<0 || j >= board[0].length)
            return false;
        if(board[i][j]==word.charAt(index)){
            if(index == word.length()-1)
                return true;
            board[i][j] = ' ';
            boolean exists = existPath(board,word,i+1,j,index+1) || existPath(board,word,i-1,j,index+1) || existPath(board,word,i,j+1,index+1) || existPath(board,word,i,j-1,index+1);
            board[i][j] = word.charAt(index);
            return exists;
        }else
            return false;
    }
}
