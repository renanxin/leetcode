/*
	本题的目标是利用两个队列模拟出栈的功能，我们可以设置两个队列，一个是用来存储数据，而两外一个
	则是用来在相关操作的时候存储临时变量，比如pop方法，我们可以将队列1中除最后一个元素之外的都转移到队列2中，最后再将队列2赋给队列1
	top方法大致与pop方法相似，不过不用移除最后一个元素
*/

// solution for 225
    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int len = queue1.size();
            while(len>1){
                queue2.add(queue1.remove());
                --len;
            }
            int res = queue1.remove();
            queue1 = queue2;
            return res;
        }

        /** Get the top element. */
        public int top() {
            if(queue1.peek()==null)
                return -1;
            int len =  queue1.size();
            while(len>1){
                queue2.add(queue1.remove());
                --len;
            }
            int res = queue1.remove();
            queue2.add(res);
            queue1 = queue2;
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.size()==0;
        }
    }