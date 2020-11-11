import java.util.*;

/**
 * 对于寻找这种连续子串，我们可以每次寻找从当前遍历点向前搜寻满足条件的个数，设置pvc表示子串开始位置，
 * 这是因为遇到了值大于R的，肯定不能满足，如果遇到介于L和R之间的值，从当前节点可以有i-pvc+1个满足条件的字串
 * 遇到小于的值，则至少需要包含往前介于L和R之间的值开始的序列，所以是pvc
 */
class Solution{

    // solution for 795
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int begin = 0, pvc = 0,res = 0;
        for(int i=0;i<A.length;++i){
            if(A[i]>=L && A[i]<=R){
                pvc = i-begin+1;
                res += pvc;
            }else if(A[i]<L)
                res += pvc;
            else{
                pvc = 0;
                begin = i+1;
            }
        }
        return res;
    }
}
