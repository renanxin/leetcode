/*
	目标是找打出现次数次数大于nums总数1/3的数字，我们可以获得nums中每个数字出现的次数，并对统计过的数字设置为-1，所以需要首先判断-1
	满不满足条件，满足则添加到res，然后从下标0开始，找到第一个不为-1的数，并统计出现次数，不断迭代，直到nums数组
	全为-1
*/

public class Solution {

   // solution for 229
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums==null)  return res;
        int tmp,num=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==-1){
                num+=1;
            }
        }
        if(num>nums.length/3)
            res.add(-1);
        num=0;
        while(true){
            int i=0;
            for(i=0;i<nums.length;++i){
                if(nums[i]!=-1)
                    break;
            }
            if(i==nums.length)
                break;
            tmp = nums[i];
            num = 1;
            nums[i]=-1;
            for(i=i+1;i<nums.length;++i){
                if(nums[i]==tmp){
                    ++num;
                    nums[i]=-1;
                }
            }
            if(num>nums.length/3)   res.add(tmp);
        }
        return res;
    }
}
