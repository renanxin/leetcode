class Solution {
    /**
     * 首先将nums转化为char数组并进行从大到小排序，找到与未排序数组从左到右第一个不同的值
     * 在未排序数组从右到左找到第一个值相等元素，与从左到右第一个小于该值的元素交换位置，最后直接转化为int返回即可
     * @param num
     * @return
     */
    // solution for 670
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        char[] res_nums = nums.clone();
        Arrays.sort(nums);
        char firstMax = '9'-10;
        for(int i=0;i<nums.length;++i){
            if(res_nums[i]!=nums[nums.length-1-i]){
                firstMax = nums[nums.length-1-i];
                break;
            }
        }
        if(firstMax < '0')
            return num;
        int firstIndex = res_nums.length-1;
        while(firstIndex>=0){
            if(res_nums[firstIndex]==firstMax)
                break;
            firstIndex -=1;
        }
        for(int i=0;i<res_nums.length;++i){
            if(res_nums[i]<firstMax){
                res_nums[firstIndex] = res_nums[i];
                res_nums[i] = firstMax;
                break;
            }
        }
        return Integer.parseInt(new String(res_nums));
    }
}