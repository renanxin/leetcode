class Solution {

    // solution for 566
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length==0||nums[0].length==0||(nums.length*nums[0].length!=r*c))
            return nums;
        int[][] res = new int[r][c];
        int x=0,y=0;
        for(int i=0;i<nums.length;++i){
            for(int j=0;j<nums[0].length;++j){
                if(y>=c){
                    x+=1;
                    y=0;
                }
                res[x][y++] = nums[i][j];
            }
        }
        return res;
    }
}