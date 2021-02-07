import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 53-1 在排序数组中查找数字 I
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        int begin1 = 0,begin2 = 0,end1 = nums.length,end2=nums.length;
        while(begin1<end1){
            int mid = begin1+(end1-begin1)/2;
            if(nums[mid]>target)
                end1 = mid;
            else if(nums[mid]<target)
                begin1 = mid;
            else{
                if(mid>=1 && nums[mid-1]==target)
                    end1 = mid-1;
                else{
                    end1 = mid;
                    break;
                }
            }
        }

        if(nums[end1]!=target)
            return 0;

        while(begin2<end2){
            int mid = begin2+(end2-begin2)/2;
            if(nums[mid]>target)
                end2 = mid;
            else if(nums[mid]<target)
                begin2 = mid;
            else{
                if(mid<nums.length-1 && nums[mid+1]==target)
                    begin2 = mid+1;
                else{
                    begin2 = mid;
                    break;
                }
            }
        }
        return begin2-end1+1;
    }
}
