import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 57-2 和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int begin=1,end=1,sum=0;
        while(begin<=(target+1)/2){
            sum += end;
            if(sum<target)
                end+=1;
            else if(sum==target){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=begin;i<=end;++i)
                    list.add(i);
                res.add(list);
                sum -= begin;
                begin+=1;
            }else{
                sum -= begin;
                begin+=1;
            }
        }
        int[][] resArray = new int[res.size()][];
        int index = 0;
        for(ArrayList<Integer> array:res)
            resArray[index++] = Arrays.stream(array.toArray()).mapToInt((val)->(int)val).toArray();
        return  resArray;
    }
}
