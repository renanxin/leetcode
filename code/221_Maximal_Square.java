/*
	此题就是寻找一个二维数组中由1构成的正方形的最大面积
	直接暴力遍历，如果遇到1，再设置一个tmp变量，表示以当前点为左上角的正方形的边长，再从相较于上次新增
	的那部分面积开始遍历，如果对应的位置都是1，则表明正方形的边长为tmp是满足的，则更新最终的返回值边长，最终返回的时候直接返回平方即可
*/

public class Solution {
	

    // solution for 221
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)     return 0;
        int res = 0;
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]=='1'){
                    if(res==0)
                        res = 1;
                    int tmp = 2;
                    while(true){
                        if(isSquare(matrix,i,j,tmp)) {
                            if (tmp > res)
                                res = tmp;
                        }
                        else
                            break;
                        tmp+=1;
                    }
                }
            }
        }
        return res*res;
    }

    public boolean isSquare(char[][] nums,int i,int j,int tmp){
        if(i+tmp-1>=nums.length||j+tmp-1>=nums[0].length)
            return false;
        for(int k=j;k<j+tmp;++k)
            if(nums[i+tmp-1][k]=='0')
                return false;
        for(int k=i;k<i+tmp-1;++k)
            if(nums[k][j+tmp-1]=='0')
                return false;
        return true;
    }
}
