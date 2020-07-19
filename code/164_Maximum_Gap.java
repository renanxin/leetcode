/*
	遇到这类问题肯定先想到的是要给数组排序，
	但是题目要求是要线性的时间和空间，那么只能用桶排序或者基排序。
	这里用桶排序 Bucket Sort 来做，首先找出数组的最大值和最小值，然后要确定每个桶的容量，
	即为 (最大值 - 最小值) / 个数 + 1，在确定桶的个数，即为 (最大值 - 最小值) / 桶的容量 + 1，
	然后需要在每个桶中找出局部最大值和最小值，而最大间距的两个数不会在同一个桶中，
	而是一个桶的最小值和另一个桶的最大值之间的间距，这是因为所有的数字要尽量平均分配到每个桶中，
	而不是都拥挤在一个桶中，这样保证了最大值和最小值一定不会在同一个桶中，可以证明一个桶中的最大
	距离不会大于每个桶的容量，而我们桶的数量是大于等于元素个数的，所以必然在相邻桶之间存在最大间距，
	见代码如下：
	
*/

class MinStack {
	// solution_1 for 164
    public int maximumGap(int[] nums) {
        // 数组长度为1
        if(nums.length<2)
            return 0;
        // 获取nums中的最大值和最小值
        int nums_min = nums[0],nums_max = nums[0];
        for(int num:nums){
            nums_min = Math.min(num,nums_min);
            nums_max = Math.max(num,nums_max);
        }
        // 确定桶的大小和容量
        // 计算桶的容量
        int bucketSize = Math.max(1,(nums_max-nums_min)/((int)nums.length));
        // 计算桶的个数
        int bucketNums = (int) Math.ceil((nums_max-nums_min+1)/(float)bucketSize);
        // 初始化桶
        List<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i=0;i<bucketNums;++i)
            bucket.add(new ArrayList<Integer>());
        //　将相关的数据存入桶中
        for(int i=0;i<nums.length;++i){
            if(nums[i]==nums_max)
                bucket.get(bucket.size()-1).add(nums[i]);
            else{
                int bucketIndex = (nums[i]-nums_min)/bucketSize;
                bucket.get(bucketIndex).add(nums[i]);
            }
        }
        // 对桶中每个元素进行排序
        for(int i=0;i<bucketNums;++i){
            Collections.sort(bucket.get(i));
        }
        // 寻找桶中最大间距
        int pre = -1,max_gap = 0;
        for(int i=0;i<bucketNums;++i){
            for(int j=0;j<bucket.get(i).size();++j){
                if(pre!=-1){
                    max_gap = Math.max(max_gap,bucket.get(i).get(j)-pre);
                }
                pre = bucket.get(i).get(j);
            }
        }
        return max_gap;
    }
}
