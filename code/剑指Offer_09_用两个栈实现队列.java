import java.util.Stack;

// 09 用两个栈实现队列
class CQueue {

    Stack<Integer> stack1,stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            return stack1.pop();
        }else{
            if(stack2.isEmpty())
                return -1;
            else{
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                return stack1.pop();
            }
        }
    }
}
