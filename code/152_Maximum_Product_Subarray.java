import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	本题的主要目标是将字符串中的每个单词逆序排列，同时忽略字符串首位空格，而每个单词间只用单个单词隔开
	首先利用string自身提供的trim和split方法将字符串切割成若干个单词，再利用StringBuilder将这些单词逆向拼接起来
	最后使用StringBuilder的toString方法得到目标字符串
*/

public class Solution {
     // solution for 152
    public int maxProduct(int[] nums){
        if(nums.length==1)  return nums[0];
        int max_v = nums[0],min_v = nums[0],res = nums[0],max_tmp,min_tmp;
        for(int i=1;i<nums.length;++i){
            max_tmp = max_v*nums[i];
            min_tmp = min_v*nums[i];
            max_v = Math.max(max_tmp,Math.max(min_tmp,nums[i]));
            min_v = Math.min(max_tmp,Math.min(min_tmp,nums[i]));
            res = Math.max(res,max_v);
        }
        return res;
    }
}
