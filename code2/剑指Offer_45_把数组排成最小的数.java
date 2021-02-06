import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 45 把数组排成最小的数
    public static String minNumber(int[] nums) {
        Stream<Integer> boxed = Arrays.stream(nums).boxed();
        Integer[] numsIn = boxed.toArray(Integer[]::new);
        Arrays.sort(numsIn, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2))
                    return 0;
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int num:numsIn)
            builder.append(num);
        return builder.toString();
    }
}
