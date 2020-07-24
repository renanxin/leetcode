/*
	此题可以使用深度遍历，当遍历到一个节点值为1的时候，就将计数变量res的值加1，同时对其周围的坐标进行深度优先遍历，
	对于遍历到的岛屿值设置为2，这里还添加了类属性cols和rows用来代表数组的列数和行数
	
*/

public class Solution {
	
   // rows和cols分别代表着grid数组的行数和列数
   private int rows,cols;
   
   public int numIslands(char[][] grid){
        int res = 0;
        if(grid==null||grid.length==0||grid[0].length==0)
            return res;
        rows = grid.length;
        cols = grid[0].length;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]=='1') {
                    ++res;
                    runDFS(grid,i,j);
                }
            }
        }
        return res;
    }
	
	// 进行dfs遍历，将值为1的坐标周围同为1的也转化为2
    public void runDFS(char[][] grid,int i,int j){
        grid[i][j] = '2';
        if(isValidGrid(i-1,j)&&grid[i-1][j]=='1')
            runDFS(grid,i-1,j);
        if(isValidGrid(i+1,j)&&grid[i+1][j]=='1')
            runDFS(grid,i+1,j);
        if(isValidGrid(i,j-1)&&grid[i][j-1]=='1')
            runDFS(grid,i,j-1);
        if(isValidGrid(i,j+1)&&grid[i][j+1]=='1')
            runDFS(grid,i,j+1);
    }

    

    // 判断当前坐标是否有效
    public boolean isValidGrid(int i,int j){
        if(i<0||i>=rows)
            return false;
        if(j<0||j>=cols)
            return false;
        return true;
    }
}
