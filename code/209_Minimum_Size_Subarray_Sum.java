/*
	本题的目标是求在数组nums中和不小于s的连续序列的最小长度
	可以设置一个sum表示当前和，begin和end分别表示序列的开始和结束，然后对nums开始遍历，并将sum加上当前nums的值，如果大于等于s，则
	需要对begin进行增大，同时不断对sum进行更新，当sum再次小于s的时候结束，同时对返回值res进行更新
*/

public class Solution {
	
   // solution for 209
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE,begin=0,end=0,sum=0;
        boolean flag = false;
        while(end<nums.length){
            sum += nums[end];
            if(sum>=s) {
                flag = true;
                while(begin<=end && sum>=s){
                    sum -= nums[begin];
                    ++begin;
                }
                if(end+1>=begin && flag)
                    res = end - begin + 2<res?end - begin + 2:res;
                flag = false;
            }
            end += 1;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
