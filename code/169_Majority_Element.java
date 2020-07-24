/*
	此题的目标是求数组中的众数，并且保证众数出现的次数大于n/2
	因为众数出现的次数大于n/2，所有众数出现的字数减去其它数字出现字数的总和大于0
	故可以设置一个majority和对应的frequency，遍历数组，如果当前数组和majority相等
	则frequency的值加1，如果不相等，则frequency减去1，此时判断frequency的值，如果
	小于0，表示其它数字出现的次数多，将majority的值赋为当前值
	
*/

public class Solution {

    // solution for 169
    public int majorityElement(int[] nums){
        int majority = nums[0], frquency = 1;
        for(int i=1;i<nums.length;++i){
            if(majority == nums[i])
                ++ frquency;
            else{
                -- frquency;
                if(frquency<0){
                    majority = nums[i];
                    frquency = 1;
                }
            }
        }
        return majority;
    }
	
}
