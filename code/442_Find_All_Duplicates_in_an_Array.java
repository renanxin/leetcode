class RandomizedCollection {

    // solution for 442

    /**
     * 取负数法，主要是nums中的数字是从1～n，所以直接减去1就可以映射到0～n-1
     * 将每个出现的数对应index处的数取反，如果发现index处的值本身就是负数，说明
     * 当前数出现过两次
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            int num_abs = Math.abs(num);
            if(nums[num_abs-1]<0)
                res.add(num_abs);
            nums[num_abs-1] = -nums[num_abs-1];
        }
        return res;
    }
}