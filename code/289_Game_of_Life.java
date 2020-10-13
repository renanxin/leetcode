public class Solution {

    int[][] variable = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    // solution for 289
    public void gameOfLife(int[][] board) {
        int num;
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                num = getOneNum(board,i,j);
                if(board[i][j]==1){
                    if(num<2||num>3)
                        board[i][j] = 3;
                }else{
                    if(num==3)
                        board[i][j]=2;
                }
            }
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j) {
                if(board[i][j]==3)
                    board[i][j]=0;
                else if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }

    public int getOneNum(int[][] board,int i,int j){
        int num = 0;
        for(int k=0;k<variable.length;++k){
            if(validCoordinate(board,i+variable[k][0],j+variable[k][1])) {
                if (board[i + variable[k][0]][j + variable[k][1]] == 1 || board[i + variable[k][0]][j + variable[k][1]] == 3) {
                    num += 1;
                }
            }
        }
        System.out.println(num);
        return num;
    }

    public boolean validCoordinate(int[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        return true;
    }
}
