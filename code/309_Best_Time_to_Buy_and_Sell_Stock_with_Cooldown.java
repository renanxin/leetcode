import java.util.*;



class Solution{

    // solution for 309
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        if(prices.length==2)
            return Math.max(prices[1] - prices[0], 0);
        int pre2sell=0,pre1sell=Math.max(0,prices[1]-prices[0]),pre1buy=Math.max(-prices[0],-prices[1]);
        int res = pre1sell;
        for(int i=2;i<prices.length;++i){
            int tmpSell = Math.max(pre1sell,pre1buy+prices[i]);
            int tmpBuy = Math.max(pre2sell-prices[i],pre1buy);
            pre2sell = pre1sell;
            pre1buy = tmpBuy;
            pre1sell = tmpSell;
            res = Math.max(res,tmpSell);
        }
        return res;
    }
}
