/*
	直接深度优先遍历即可，先从头到尾遍历board数组，如果与word的首字母相等，则从它的四周入手，依次判断受否
	与接下来的字母相等，相等则往更深的层次探索
*/

public class Solution {
	
   int rows;
    int cols;

    // solution for 212
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res = new ArrayList<>();
        if(board==null||board.length==0||board[0].length==0)
            return res;
        rows = board.length;
        cols = board[0].length;
        for(String word:words) {
            if(existsWord(board,word))
                res.add(word);
        }
        return res;
    }
    // 判断borad中是否存在word
    public boolean existsWord(char[][] board,String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (word.charAt(0) == board[i][j])
                    if (existsWord(board, word, i, j, 1))
                        return true;
            }
        }
        return false;
    }

    public boolean existsWord(char[][] board,String word,int row,int col,int index){
        if(index==word.length())    return true;
        board[row][col] = '.';
        if(isValidIndex(row-1,col) && word.charAt(index)==board[row-1][col] && existsWord(board,word,row-1,col,index+1))
        {
            board[row][col]=word.charAt(index-1);
            return true;
        }
        if(isValidIndex(row,col-1) && word.charAt(index)==board[row][col-1]  && existsWord(board,word,row,col-1,index+1))
        {
            board[row][col]=word.charAt(index-1);
            return true;
        }
        if(isValidIndex(row+1,col) && word.charAt(index)==board[row+1][col]  && existsWord(board,word,row+1,col,index+1))
        {
            board[row][col]=word.charAt(index-1);
            return true;
        }
        if(isValidIndex(row,col+1) && word.charAt(index)==board[row][col+1]  && existsWord(board,word,row,col+1,index+1))
        {
            board[row][col]=word.charAt(index-1);
            return true;
        }
        board[row][col]=word.charAt(index-1);
        return false;
    }

    public boolean isValidIndex(int i,int j){
        if(i<0||i>=rows)    return false;
        if(j<0||j>=cols)     return  false;
        return true;
    }
}
