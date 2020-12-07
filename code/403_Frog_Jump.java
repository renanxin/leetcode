import java.util.*;



class Solution{

    public boolean canCross(int[] stones) {
        if (stones.length < 1 || stones.length == 2 && stones[1] == 1)
            return true;
        else if (stones.length == 2 && stones[1] != 1)
            return false;
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
        for(int i=0;i<stones.length;++i)
            dp.put(stones[i],new HashSet<Integer>());
        dp.get(0).add(1);
        for(int i=0;i<stones.length;++i){
            int stone = stones[i];
            for(int step:dp.get(stone)){
                int reach = step + stone;
                if(reach==stones[stones.length-1])
                    return true;
                HashSet<Integer> set_tmp = dp.get(reach);
                if(set_tmp!=null){
                    set_tmp.add(step);
                    if(step>1)
                        set_tmp.add(step-1);
                    set_tmp.add(step+1);
                }
            }
        }
        return false;
    }
}
