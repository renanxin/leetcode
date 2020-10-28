class Solution {
    // solution for 695
    int tmp=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        int res = 0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    tmp=0;
                    removeIsland(grid,i,j);
                    res = tmp>res?tmp:res;
                }
            }
        }
        return res;
    }

    public void removeIsland(int[][] grid,int i,int j){
        if(!(i<0||i>=grid.length||j<0||j>=grid[0].length)&&grid[i][j]==1){
            grid[i][j]=0;
            ++tmp;
            removeIsland(grid,i+1,j);
            removeIsland(grid,i-1,j);
            removeIsland(grid,i,j+1);
            removeIsland(grid,i,j-1);
        }
    }
}