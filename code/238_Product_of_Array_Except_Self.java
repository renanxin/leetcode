/**
     * 这题是得到一个二叉树从根节点到叶子节点的所有路径，将结果存储在List中
     * 对于从根节点到叶子节点的路径，可以采用后序遍历，当遍历到一个叶子节点的时候，
     * 将栈tmp中的节点一次连接成字符串
*/

public class Solution {

    // solution for 238
    /*
        每个位置的值可以是除了自己之外所有数字的乘积。所以可以顺序和倒序便利一次，
        得到到某个数为止的值之后倒序也设置一个累乘变量得到
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length-1;++i){
            res[i] = res[i-1]*nums[i];
        }
        int suffix = 1;
        for(int i=nums.length-1;i>0;--i){
            res[i] = res[i-1]*suffix;
            suffix *= nums[i];
        }
        res[0] = suffix;
        return res;
    }
}
