import java.util.*;


/**
 * 注意好那个数组中所有元素一次为0、1、2...数组长度
 */
class Solution{
    // solution for 769
    public int maxChunksToSorted_simple(int[] arr) {
        int res = 0, tmp_max = -1;
        for(int i=0;i<arr.length;++i){
            if(arr[i]>tmp_max)
                tmp_max = arr[i];
            if(tmp_max == i)
                res += 1;
        }
        return res;
    }
}
