import java.util.*;



class Solution{

    // solution for 740
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] info = new int[10001];
        for(int num:nums)
            info[num] += 1;
        int[] dp = new int[10001];
        int index = 0;
        for(int i=0;i<info.length;++i){
            if(info[i]!=0)
                break;
        }
        dp[index] = index*info[index];
        if(index==info.length)
            return dp[index];
        index+=1;
        if(info[index]==0)
            dp[index] = dp[index-1];
        else
            dp[index] = Math.max(dp[index-1],info[index] * index);
        for(int i=index+1;i<info.length;++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+info[i]*i);
        }
        return dp[dp.length-1];
    }
}
