class Solution {

    // solution for 581
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int x=0,y=nums.length-1;
        while(x<nums.length && tmp[x]==nums[x])
            x++;
        while(y>=0 && tmp[y]==nums[y])
            y--;
        x--;
        y++;
        return y-x-1>0?y-x-1:0;
    }
}