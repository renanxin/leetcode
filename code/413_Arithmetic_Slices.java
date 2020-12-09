import java.util.*;



class Solution{

    // solution for 413
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;
        int res=0,dp=0;
        for(int i=2;i<A.length;++i){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                ++dp;
                res += dp;
            }else{
                dp = 0;
            }
        }
        return res;
    }
}
