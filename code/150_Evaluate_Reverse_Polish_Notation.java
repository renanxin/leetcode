import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	此题其实就是对后缀表达式求值，简单地使用栈便可以完成
	对于每个元素，判断其是否是符号，如果是符号，则从栈中取出两个元素，并按照符号的类型进行运算
	其它类型直接压入栈中，最后返回栈中元素即可
*/

public class Solution {

	// solution for 150
    public int evalRPN(String[] tokens){
        Stack<Integer> nums = new Stack<>();
        int num1,num2;
        for(String token:tokens){
            switch (token){
                case "+":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1+num2);
                    break;
                case "-":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1-num2);
                    break;
                case "*":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1*num2);
                    break;
                case "/":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1/num2);
                    break;
                default:
                    nums.push(Integer.parseInt(token));
            }
        }
        return nums.pop();
    }
    
}
