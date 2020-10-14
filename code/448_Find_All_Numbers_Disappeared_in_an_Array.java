class RandomizedCollection {

     // solution for 448
    /**
     * 取负数法，主要是nums中的数字是从1～n，所以直接减去1就可以映射到0～n-1
     * 将每个数对应index处的值转化为0或者取反，最后遍历数组得到值仍大于0，将此处
     * 的index+1添加到返回值
     */
   public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for(int i=0;i<nums.length;++i){
        int numAbs = Math.abs(nums[i]);
        if(numAbs-1<i)
            nums[numAbs-1]=0;
        else if(nums[numAbs-1] > 0)
            nums[numAbs-1] *= -1;
    }
    for(int i=0;i<nums.length;++i){
        if(nums[i]>0)
            res.add(i+1);
    }
    return res;
}
}