/*
	可以设置两个变量start和end分别表示连续序列的开始和结尾，遍历数组的时候，可以判断当前的值是否比end的值大1，
	正好大1，可以将end的值更新为当前值，不是则start和end以start->end的形式存入返回数组中，遍历结束的时候，也需要
	将值加入返回值res中
*/

public class Solution {

   // solution for 228
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        int start = nums[0],end=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i]==end+1)
                end = nums[i];
            else{
                if(start==end)
                res.add(Integer.toString(start));
                else
                    res.add(start+"->"+end);
                start = nums[i];
                end = nums[i];
            }
        }
        if(start==end)
            res.add(Integer.toString(start));
        else
            res.add(start+"->"+end);
        return res;
    }
}
