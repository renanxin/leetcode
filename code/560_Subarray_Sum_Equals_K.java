/**
 * 我们定义一个sum数组，其中sum[index]表示nums中从0到index所有数字的和
 * 对于nums从i到j子串之和等于nums[j]-nums[i]，这样我们可以将sum[index]的值存储在一个map中
 * 其中键为sum的值，值为出现的次数，这样对于sum[index]，我们可以得到sum[index]-k出现的次数就可以了
 */

class Solution {

    // solution for 560
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0,  sum = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;++i){
            sum += nums[i];
            if(map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}