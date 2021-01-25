import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 11 旋转数组的最小数字
    public int minArray(int[] numbers) {
        int begin=0,end=numbers.length-1;
        while(begin<end-1){
            int mid = begin + (end-begin)/2;
            if(numbers[mid]<numbers[begin])
                end = mid;
            else{
                if(numbers[mid]>numbers[end])
                    begin = mid;
                else if(numbers[mid]<numbers[end])
                    return numbers[begin];
                else{
                    int min = Integer.MAX_VALUE;
                    for(int i=begin;i<=end;++i)
                        min = Math.min(min,numbers[i]);
                    return min;
                }
            }
        }
        return Math.min(numbers[begin],numbers[end]);
    }



    public int minArray_better(int[] numbers) {
        int begin=0,end=numbers.length-1;
        while(begin<end){
            int mid = begin + (end-begin)/2;
            if(numbers[mid]>numbers[end])
                begin = mid+1;
            else if(numbers[mid]<numbers[end])
                end = mid;
            else
                end = end-1;
        }
        return numbers[begin];
    }
}
