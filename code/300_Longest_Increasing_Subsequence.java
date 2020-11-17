import java.util.*;


/**
 * 这里用到了二分查找法，所以才能加快运行时间哇。思路是，先建立一个数组 ends，把首元素放进去，
 * 然后比较之后的元素，如果遍历到的新元素比 ends 数组中的首元素小的话，替换首元素为此新元素，
 * 如果遍历到的新元素比 ends 数组中的末尾元素还大的话，将此新元素添加到 ends 数组末尾(注意不覆盖原末尾元素)。
 * 如果遍历到的新元素比 ends 数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，
 * 覆盖掉位置的原来的数字，以此类推直至遍历完整个 nums 数组，此时 ends 数组的长度就是要求的LIS的长度，
 * 特别注意的是 ends 数组的值可能不是一个真实的 LIS，比如若输入数组 nums 为 {4, 2， 4， 5， 3， 7}，
 * 那么算完后的 ends 数组为 {2， 3， 5， 7}，可以发现它不是一个原数组的 LIS，只是长度相等而已，千万要注意这点
 */
class Solution{

    // solution for 300
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2)   return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;++i){
            int index = binarySearchNotMin(dp,nums[i],0,count);
            if(index==count)
                dp[count++] = nums[i];
            else
                dp[index] = nums[i];
        }
        return count;
    }


    // 寻找数组中不小于target的值下标
    public int binarySearchNotMin(int[] nums,int target,int begin,int end){
        while(begin<end){
            int mid = begin + (end-begin)/2;
            if(nums[mid]>=target)
                end = mid;
            else
                begin = mid + 1;
        }
        return end;
    }
}
