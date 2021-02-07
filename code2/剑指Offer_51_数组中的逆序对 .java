import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 51 数组中的逆序对
    int res = 0;

    public int reversePairs(int[] nums) {
        reversePairs(nums, 0, nums.length - 1);
        return res;
    }

    public void reversePairs(int[] nums, int begin, int end) {
        if (begin >= end)
            return;
        if (begin + 1 == end) {
            if (nums[begin] > nums[end]) {
                ++res;
                int tmp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = tmp;
            }
            return;
        }
        int mid = begin + (end - begin) / 2;
        reversePairs(nums, begin, mid);
        reversePairs(nums, mid + 1, end);
        ArrayList<Integer> list = new ArrayList<>();
        int index1 = begin, index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (nums[index1] < nums[index2]) {
                list.add(nums[index1++]);
            } else {
                res += mid - index1 + 1;
                list.add(nums[index2++]);
            }
        }
        while (index1 <= mid)
            list.add(nums[index1++]);
        while (index2 <= end)
            list.add(nums[index2++]);
        int index = begin;
        for (Integer num : list) {
            nums[index++] = num;
        }
    }
}
