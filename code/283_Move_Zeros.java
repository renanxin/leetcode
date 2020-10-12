public class Solution {

    // solution for 283
    /*
        设置两个变量fast，slow，fast至少比slow大1，我们遍历过程中要保证slow之前的数都是非0，slow和fast之间全为0（不包括slow和fast），所以我们可以根据
        当前fast和slow值的取值分类讨论，如果slow不为0，则直接将slow加1，同时保证slow和fast的大小关系
        如果slow为0，fast不为0，交换二者的值，重复slow不为0的操作，都是0的话，直接fast加1
    */
    public void moveZeroes(int[] nums) {
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=0){
                slow++;
                if(fast==slow)
                        fast++;
            }else{
                if(nums[fast]!=0){
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    slow ++;
                    if(fast==slow)
                        fast++;
                }else
                    fast ++;
            }
        }
    }
}
