import java.util.*;


/**
 * 这道题给了一个小游戏，有一个数组，两个玩家轮流取数，说明了只能从开头或结尾取，问我们第一个玩家能赢吗。这道题博主想到了应该是用 Minimax 来做，
 * 由于之前有过一道这样的题 Guess Number Higher or Lower II，所以依稀记得应该要用递归的方法，而且当前玩家赢返回 true 的条件就是递归调用下一个玩家输返回 false。
 * 这里需要一个变量来标记当前是第几个玩家，还需要两个变量来分别记录两个玩家的当前数字和，在递归函数里面，如果当前数组为空了，直接比较两个玩家的当前得分即可，
 * 如果数组中只有一个数字了，根据玩家标识来将这个数字加给某个玩家并进行比较总得分。如果数组有多个数字，分别生成两个新数组，一个是去掉首元素，一个是去掉尾元素，
 * 然后根据玩家标识分别调用不同的递归，只要下一个玩家两种情况中任意一种返回 false 了，那么当前玩家就可以赢了，参见代码如下：
 */
class Solution{

    // solution for 486
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;++i)
            dp[i][i] = nums[i];
        for(int i=1;i<nums.length;++i) {
            for (int j=0,k=i; k<nums.length; ++j,++k) {
                dp[j][k] = Math.max(nums[j]-dp[j+1][k],nums[k]-dp[j][k-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}
