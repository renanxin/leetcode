import java.util.*;



class Solution{

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(src==dst)
            return 0;
        ArrayList<Integer[]>[] nodes = new ArrayList[101];
        for(int i=0;i< nodes.length;++i)
            nodes[i] = new ArrayList<Integer[]>();
        for(int i=0;i<flights.length;++i){
            nodes[flights[i][0]].add(new Integer[]{flights[i][1],flights[i][2]});
        }
        int[] arrival_min = new int[101];
        for(int i=0;i<arrival_min.length;++i)
            arrival_min[i] = Integer.MAX_VALUE;
        arrival_min[src] = 0;
        Map<Integer, Integer> from = new HashMap<>();
        from.put(src,0);
        K++;
        if(K>n-1)
            K = n-1;
        while(K>0){
            Map<Integer,Integer> tmp = new HashMap<>();
            for(int key:from.keySet()){
                int cost = from.get(key);
                for(int j=0;j<nodes[key].size();++j){
                    int tmp_dst = nodes[key].get(j)[0];
                    int tmp_min = nodes[key].get(j)[1]+cost;
                    if(tmp_min<arrival_min[tmp_dst]){
                        arrival_min[tmp_dst] = tmp_min;
                        tmp.put(tmp_dst,tmp_min);
                    }
                }
            }
            from  = tmp;
            K--;
        }
        return arrival_min[dst]==2147483647?-1:arrival_min[dst];
    }
}
