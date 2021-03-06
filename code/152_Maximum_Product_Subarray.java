import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	本题的目标是求最大的连续字串积
	这个求最大子数组乘积问题是由最大子数组之和 Maximum Subarray 演变而来，但是却比求最大子数组之和要
	复杂，因为在求和的时候，遇到0，不会改变最大值，遇到负数，也只是会减小最大值而已。而在求最大子数
	组乘积的问题中，遇到0会使整个乘积为0，而遇到负数，则会使最大乘积变成最小乘积，正因为有负数和0的
	存在，使问题变得复杂了不少。比如，现在有一个数组 [2, 3, -2, 4]，可以很容易的找出所有的连
	续子数组，[2]，[3]，[-2]，[4]，[2, 3]，[3, -2]，[-2, 4]，[2, 3, -2]，[3, -2, 4]，[2, 3, -2, 4]，
	然后可以很轻松的算出最大的子数组乘积为6，来自子数组 [2, 3]。但如何写代码来实现自动找出最大子数
	组乘积呢，博主最先想到的方比较简单粗暴，就是找出所有的子数组，然后算出每一个子数组的乘积，然
	后比较找出最大的一个，需要两个 for 循环，第一个 for 遍历整个数组，第二个 for 遍历含有当前数字
	的子数组，就是按以下顺序找出子数组: [2]，[2, 3]，[2, 3, -2]，[2, 3, -2, 4]，[3]，[3, -2]，[3, -2, 4]，[-2]，[-2, 4]，[4]，
	在本地测试的一些数组全部通过，于是兴高采烈的拿到 OJ 上测试，结果丧心病狂的 OJ 用一个有 15000 个数
	字的数组来测试，然后说程序的运行时间超过了要求值，一看代码，果然如此，时间复杂度 O(n2), 得想办法
	只用一次循环搞定。想来想去想不出好方法，于是到网上搜各位大神的解决方法。其实这道题最直接的方法就
	是用 DP 来做，而且要用两个 dp 数组，其中 f[i] 表示子数组 [0, i] 范围内并且一定包含 nums[i] 数字的
	最大子数组乘积，g[i] 表示子数组 [0, i] 范围内并且一定包含 nums[i] 数字的最小子数组乘积，初始化时
	f[0] 和 g[0] 都初始化为 nums[0]，其余都初始化为0。那么从数组的第二个数字开始遍历，那么此时的最
	大值和最小值只会在这三个数字之间产生，即 f[i-1]*nums[i]，g[i-1]*nums[i]，和 nums[i]。所以用三者
	中的最大值来更新 f[i]，用最小值来更新 g[i]，然后用 f[i] 来更新结果 res 即可，由于最终的结果不一
	定会包括 nums[n-1] 这个数字，所以 f[n-1] 不一定是最终解，不断更新的结果 res 才是
	
	下面的方法则是没有定义这样的最大最小数组，而是使用了三个变量用来保存，max_v,min_v和res
	而res = Math.max(res,max_v)步骤相当于从f数组中寻找到最大值
	
*/

public class Solution {
	
     // solution for 152
    public int maxProduct(int[] nums){
        if(nums.length==1)  return nums[0];
        int max_v = nums[0],min_v = nums[0],res = nums[0],max_tmp,min_tmp;
        for(int i=1;i<nums.length;++i){
			// 求得中间变量
            max_tmp = max_v*nums[i];
            min_tmp = min_v*nums[i];
			// 进行部分连续最大最小连积的更新
            max_v = Math.max(max_tmp,Math.max(min_tmp,nums[i]));
            min_v = Math.min(max_tmp,Math.min(min_tmp,nums[i]));
            res = Math.max(res,max_v);
        }
        return res;
    }
}
