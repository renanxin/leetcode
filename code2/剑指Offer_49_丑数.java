import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 49 丑数
    public int nthUglyNumber(int n) {
        int[] uglyNumber = {2, 3, 5};
        if (n == 1)
            return 1;
        PriorityQueue<Long> queue = new PriorityQueue<>(n * 3, Long::compareTo);
        HashSet<Long> set = new HashSet<>(n * 3);
        queue.add(1L);
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            Long remove = queue.remove();
            for (int num : uglyNumber) {
                Long tmp = remove * num;
                if (tmp < 0)
                    continue;
                if (!set.contains(tmp)) {
                    queue.add(tmp);
                    set.add(tmp);
                }
            }
        }
        return Math.toIntExact(queue.remove());
    }

    public int nthUglyNumber_better(int n) {
        if (n == 1)
            return 1;
        int a = 0, b = 0, c = 0, index = 1;
        int[] dp = new int[n];
        while (index < n) {
            int aTmp = dp[a] * 2, bTmp = dp[b] * 3, cTmp = dp[c] * 5;
            dp[index++] = Math.min(aTmp, Math.min(bTmp, cTmp));
            if (dp[index - 1] == aTmp)
                a++;
            if (dp[index - 1] == bTmp)
                b++;
            if (dp[index - 1] == cTmp)
                c++;
        }
        return dp[n - 1];
    }
}
