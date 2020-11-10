import java.util.*;


/**
 * 此题主要目的就是寻找是否存在不相邻的逆序对，存在逆序对就是前面值大于后面的值且不相邻，那么可以知道前i个
 * 值的最大值大于第i+2个值，就可以满足条件，直接返回false
 */
class Solution{
    // solution for 775
    public boolean isIdealPermutation(int[] A) {
        if(A.length<3)  return true;
        int maxVal = A[0];
        for(int i=2;i<A.length;++i){
            if(maxVal>A[i])
                return false;
            maxVal = maxVal>A[i-1]?maxVal:A[i-1];
        }
        return true;
    }
}
