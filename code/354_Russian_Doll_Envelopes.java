import java.util.*;



class Solution{

    // solution for 354
    public int maxEnvelopes_basic(int[][] envelopes) {
        if(envelopes.length<=1)
            return envelopes.length;
        Arrays.sort(envelopes,(int[] a,int[] b)->{return a[0]-b[0];});
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 1;
        for(int i=1;i<dp.length;++i){
            dp[i] = 1;
            for(int k=0;k<i;++k){
                if(envelopes[k][0]<envelopes[i][0] && envelopes[k][1]<envelopes[i][1] && dp[k]>=dp[i])
                    dp[i] = dp[k]+1;
            }
            if(dp[i]>res)
                res = dp[i];
        }

        return dp[envelopes.length-1];
    }

    // solution for 354
    public int maxEnvelopes_better(int[][] envelopes) {
        if(envelopes.length<=1)
            return envelopes.length;
        Arrays.sort(envelopes,(int[] a,int[] b)->{return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];});
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(envelopes[0][1]);
        int pre = envelopes[0][0];
        for(int i=1;i<envelopes.length;++i){
            int left = 0, right = dp.size();
            while(left<right){
                int mid = left + (right-left)/2;
                if(dp.get(mid)<envelopes[i][1])
                    left = mid + 1;
                else
                    right = mid;
            }
            if(right==dp.size()) {
                dp.add(envelopes[i][1]);
                pre = envelopes[i][0];
            }
            else
                dp.set(left,envelopes[i][1]);
        }
        return dp.size();
    }


    // solution for 354
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length<=1)
            return envelopes.length;
        Arrays.sort(envelopes,(int[] a,int[] b)->{return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];});
        int len=0;
        int[] dp = new int[envelopes.length];
        for(int[] num:envelopes){
            int index = Arrays.binarySearch(dp,0,len,num[1]);
            if(index<0)
                index = -(index+1);
            dp[index] = num[1];
            if(len==index)
                ++len;
        }
        return len;
    }

}
