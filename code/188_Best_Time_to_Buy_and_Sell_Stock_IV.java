/*
	就是123. Best Time to Buy and Sell Stock III昨天的题，只是把交易2次改成了交易k次。这次题目有个坑
	，就是给了一个特别大的k，导致构建数组的时候，内存超了。在123题目里也说了，如果k>=N的时候相当于没
	有限制，题目退化成了不限次数的交易，所以我们直接求今天比昨天高的部分即可。当k<N的时候，我们仍然
	使用两个变量，全局的收益g和当前天卖出股票的收益l.以下来自Grandyang的博客：	这里我们需要两个递推
	公式来分别更新两个变量local和global，参见网友Code Ganker的博客，我们其实可以求至少k次交易的最大
	利润。我们定义local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利
	润，此为局部最优。然后我们定义global[i][j]为在到达第i天时最多可进行j次交易的最大利润，此为全局最
	优。它们的递推式为：local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
	global[i][j] = max(local[i][j], global[i - 1][j])，其中局部最优值是比较前一天并少交易一次的全局最优加上大于0的差值，和前一天的局部最优加上差值后相比，两者之中取较大值，而全局最优比较局部最优和前一天的全局最优。

	
*/

class MinStack {

    // solution for 188
    public int maxProfit(int k,int[] prices){
        if(k==0||prices.length<2)   return 0;
        int res = 0;
        // 注意这里可能会给特别大的k导致内存爆了，所以k够用就行，当其大于price的长度时就表示可以为不限交易次数
        if(k>=prices.length){
            for(int i=1;i<prices.length;++i)
                if(prices[i]-prices[i-1]>0)
                    res += prices[i]-prices[i-1];
            return res;
        }
        // 交易次数有限
        int[][] tmp = new int[k][2];
        for(int i=0;i<k;++i){
            tmp[i][0] = Integer.MIN_VALUE;
            tmp[i][1] = 0;
        }
        for(int i=0;i<prices.length;++i){
            tmp[0][0] = Math.max(tmp[0][0],-prices[i]);
            tmp[0][1] = Math.max(tmp[0][1],tmp[0][0]+prices[i]);
            for(int j=1;j<k;++j){
                if(tmp[j][0]<tmp[j-1][1]-prices[i])
                    tmp[j][0] = tmp[j-1][1]-prices[i];
                if(tmp[j][1]<tmp[j][0]+prices[i])
                    tmp[j][1] = tmp[j][0]+prices[i];
            }
        }
        for(int i=0;i<k;++i)
            res = Math.max(res,tmp[i][1]);
        return res;
    }
}
