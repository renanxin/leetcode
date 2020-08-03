/*
	此题的目标是判断一个数组nums中坐标距离不大于k的两个数之间的绝对值之差能够满足不大于t
	可以使用hashset，存储nums中连续的k+1个数，首先如果t<0，则直接返回false，之后对与每个数字遍历的时候首先判断set中是否存在相等的
	数字，存在则不用说直接返回true，如果t大于0，则使用lower和higher获取set中最接近当前值的两个值，其分别大于和小于当前值，最后判断它们与当前值之间的距离是否不大于t，不大于
	则直接返回true。对于set的处理还包括了向set中添加和删除元素
	有一个点可能会忽略，就是在做差的时候可能会超过int的表达范围，所以要先转化为log才能做差
*/

public class Solution {
	

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // solution for 220
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length==0||t<0)      return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;++i){
            if(i>k)
                // 去除k个范围之外的值
                set.remove(nums[i-k-1]);
            if(set.contains(nums[i]))
                return true;
            if(t>0){
                Integer highest_num_less_curr = set.lower(nums[i]);
                Integer lowest_num_grater_curr = set.higher(nums[i]);
                if(highest_num_less_curr!=null&&(long)nums[i]-highest_num_less_curr<=t||lowest_num_grater_curr!=null&&(long)lowest_num_grater_curr-nums[i]<=t)
                    return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    }
