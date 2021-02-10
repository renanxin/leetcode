import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 61 扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        int zerosNum = 0;
        int[] flag = new int[14];
        boolean show = false;
        for(int num:nums){
            if(num==0)
                zerosNum += 1;
            else
                flag[num] += 1;
        }
        int numCount = 5 - zerosNum;
        for(int i=1;i<14;++i){
            if(flag[i]==0){
                if(show){
                    if(zerosNum>0)
                        zerosNum -= 1;
                    else
                        return numCount == 0;
                }
            }else{
                show = true;
                if(flag[i]>1)
                    return false;
                numCount -= 1;
            }
        }
        return numCount == 0;
    }
}
