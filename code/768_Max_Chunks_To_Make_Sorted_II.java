import java.util.*;

class Solution{
    // solution for 768
    public int maxChunksToSorted(int[] arr) {
        int[] sorted_arr = arr.clone();
        Arrays.sort(sorted_arr);
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        int res = 0;
        for(int i=0;i<arr.length;++i){
            map1.put(arr[i],map1.getOrDefault(arr[i],0)+1);
            map2.put(sorted_arr[i],map2.getOrDefault(sorted_arr[i],0)+1);
            if(map1.equals(map2)) {
                res += 1;
                map1.clear();
                map2.clear();
            }
        }
        return res;
    }

    // better solution for 768
    public int maxChunksToSorted_solution2(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        max[0] = arr[0];
        min[arr.length-1] = arr[arr.length-1];
        for(int i=1;i<arr.length;++i)
            max[i] = arr[i]>max[i-1]?arr[i]:max[i-1];
        for(int i=arr.length-2;i>=0;--i)
            min[i] = arr[i]>min[i+1]?min[i+1]:arr[i];
        int res = 1;
        for(int i=0;i<arr.length-1;++i){
            if(max[i]<=min[i+1])
                res += 1;
        }
        return res;
    }
}
