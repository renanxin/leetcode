import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 56-1 数组中数字出现的次数
    // 首先是将所有的数异或处理，得到的结果便是两个只出现一次的数异或结果，对于这个结果中所有位为1
    // 的位置，表示这两个只出现一次数的位在此位置不同，所以直接根据这个不同将原数组分成两组
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        if(nums.length==2){
            res[0] = nums[0];
            res[1] = nums[1];
        }else{
            int tmp = -1;
            for(int num:nums)
                tmp ^= num;
            int index=0;    // 位表示中第一个1所在的索引
            while(tmp!=0){
                index+=1;
                tmp >>= 1;
            }
            for(int num:nums){
                if(((num>>index)&1)==1)
                    res[0] ^= num;
                else
                    res[1] ^= num;
            }
        }
        return res;
    }
}
