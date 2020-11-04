class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // 便于二分查找
        int minK = 0, maxK = nums[nums.length - 1] - nums[0];
        while (minK < maxK) {
            int mid = minK + (maxK - minK) / 2;
            int left = 0, count = 0;
            for(int right=1;right<nums.length;++right){
                while(true){
                    if(nums[right]-nums[left]>mid)
                        left++;
                    else
                        break;
                }
                count += (right-left);
            }
            if(count>=k) maxK = mid;
            else
                minK = mid+1;
        }
        return minK;
    }
}