import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 59-1 滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int[]  res = new int[nums.length+1-k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        for(int i=0;i<k;++i){
            queue.add(nums[i]);
        }
        int index = 0;
        for(int i=k-1;i<nums.length;++i){
            res[index++] = queue.peek();
            queue.remove(nums[i-k+1]);
            if(i+1<nums.length)
                queue.add(nums[i+1]);
        }
        return res;
    }

    public int[] maxSlidingWindow_better(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int[]  res = new int[nums.length+1-k];
        int index = 0;
        int maxVal = nums[0],maxIndex = 0;
        for(int i=1;i<k-1;++i){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        for(int i=k-1;k<nums.length;++i){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }else if(nums[i]<maxVal){
                if(i-maxIndex+1>k){
                    maxVal = Integer.MIN_VALUE;
                    for(int j = i-k+1;j<=i;++i){
                        if(nums[j]>maxVal){
                            maxVal = nums[j];
                            maxIndex = j;
                        }
                    }
                }
            }else{
                maxIndex = i;
            }
            res[index++] = maxVal;
        }
        return res;
    }
}
