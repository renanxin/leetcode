import java.util.ArrayList;
import java.util.List;

class Solution{
    // solution for 746
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=2)
            return 0;
        int[] min_cost = new int[cost.length+1];
        min_cost[0] = 0;
        min_cost[1] = 0;
        for(int i=2;i<=cost.length;++i){
            min_cost[i] = Math.min(cost[i-1]+min_cost[i-1],cost[i-2]+min_cost[i-2]);
        }
        return min_cost[min_cost.length];
    }
}
