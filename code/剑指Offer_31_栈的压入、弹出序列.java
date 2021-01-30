import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 31 栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if(pushed.length!=popped.length)
            return false;
        if(pushed.length==0)
            return true;
        int pushIndex = 0, popIndex = 0;
        while(popIndex<popped.length && pushIndex<pushed.length){
            if(stack.empty()){
                stack.push(pushed[pushIndex++]);
            }else{
                if(stack.peek()==popped[popIndex]){
                    popIndex++;
                    stack.pop();
                }else{
                    stack.push(pushed[pushIndex++]);
                }
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()==popped[popIndex]){
                popIndex++;
                stack.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}
