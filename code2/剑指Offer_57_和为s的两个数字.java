import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 57 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==1)
            return new int[0];
        int[] res = new int[2];
        int head = 0, tail = nums.length-1;
        while(head<tail){
            int tmp = nums[head] + nums[tail];
            if(tmp==target){
                res[0] = nums[head];
                res[1] = nums[tail];
                return res;
            }else if(tmp>target)
                tail-=1;
            else
                head+=1;
        }
        return res;
    }
}
