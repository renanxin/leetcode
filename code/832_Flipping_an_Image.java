import java.util.*;



class Solution{

    // solution for 832
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for(int i=0;i<A.length;++i){
            for(int j=0;j<A.length/2;++j){
                int tmp = A[i][j];
                A[i][j] = 1- A[i][len-1-j];
                A[i][len-1-j] = 1 - tmp;
            }
            if(len%2==1)
                A[i][(len-1)/2] = 1- A[i][(len-1)/2];
        }
        return A;
    }
}
