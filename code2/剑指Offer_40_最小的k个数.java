import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 40 最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] flag = new int[10001];
        for (int i = 0; i < arr.length; ++i) {
            flag[arr[i]] = 1;
        }
        int[] res = new int[k];
        for (int i = 0, j = 0; i <= 10001 && j < k; ++i) {
            if (flag[i] == 1)
                res[j++] = i;
        }
        return res;
    }
}
