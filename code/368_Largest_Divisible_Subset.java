import java.util.*;



class Solution{

    // solution for 368
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length==1)
            res.add(nums[0]);
        if(nums.length<2)
            return res;

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] tmp = new int[nums.length];
        tmp[0] = -1;
        for(int i=0;i<nums.length;++i){
            if(tmp[i]==0)
                tmp[i] = -1;
            for(int j=i+1;j<nums.length;++j){
                if(nums[j]%nums[i]==0){
                    if(dp[i]+1>dp[j]){
                        dp[j] = dp[i]+1;
                        tmp[j] = i+1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=1;i<nums.length;++i)
            max = dp[i]>dp[max]?i:max;
        while (true){
            res.add(nums[max]);
            if(tmp[max]==-1)
                break;
            max = tmp[max]-1;
        }
        return res;
    }
}
