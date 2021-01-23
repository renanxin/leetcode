import java.util.ArrayDeque;
import java.util.Deque;/class Solution {

    // solution for 862
    public int shortestSubarray(int[] A, int K) {
        int res = Integer.MAX_VALUE;
        int[] sums = new int[A.length+1];
        for(int i=1;i<=A.length;++i)
            sums[i] = sums[i-1]+A[i-1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<=A.length;++i){
            System.out.println(deque);
            while(!deque.isEmpty() && sums[i]-sums[deque.getFirst()]>=K){
                res = Math.min(res,i-deque.getFirst());
                deque.removeFirst();
            }
            while(!deque.isEmpty() && sums[deque.getLast()]>=sums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}