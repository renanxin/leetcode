/**
 * 首先是判断price的长度，如果小于等于2，则直接做判断
 * 之后设置当前最小值tmp_min和tmp_max，找到第一个上升序列，将序列第一个值
 * 赋值给tmp_min，之后遇到的数如果比tmp_max大，则将其的值赋值给tmp_max，
 * 否则判断其与tmp_max的差，如果大于fee，则进行一次买卖，因为这就可以赚到钱
 * 如果tmp_min小于当前值，则修改tmp_min和tmp_max
 */

class Solution {
    // solution for 714
    public int maxProfit(int[] prices, int fee) {
        if(prices.length<=1)    return 0;
        if(prices.length==2)    return prices[1]-prices[0]>fee?prices[1]-prices[0]-fee:0;
        int res = 0, tmp_min = prices[0],tmp_max=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;++i){
            if(prices[i]>tmp_max) {
                if(tmp_max==Integer.MIN_VALUE && prices[i]<tmp_min)
                    tmp_min = prices[i];
                else
                    tmp_max = prices[i];
            }
            else{
                if(tmp_max!=Integer.MIN_VALUE && tmp_max-tmp_min>fee && tmp_max-prices[i]>fee){
                    res += (tmp_max-tmp_min-fee);
                    tmp_min = prices[i];
                    tmp_max = Integer.MIN_VALUE;
                }else{
                    if(tmp_min>prices[i]){
                        tmp_min = prices[i];
                        tmp_max = Integer.MIN_VALUE;
                    }
                }
            }
        }
        if(tmp_max!=Integer.MIN_VALUE)
            res += (tmp_max-tmp_min-fee>0?tmp_max-tmp_min-fee:0);
        return res;
    }
}