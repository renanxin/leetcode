import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;
import java.util.stream.Stream;


class Solution{

    // 59-2 队列的最大值
    class MaxQueue {

        Deque<Integer> deque;
        Queue<Integer> queue;
        int removed;

        public MaxQueue() {
            deque = new ArrayDeque<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            if(deque.size()==0)
                return deque.getFirst();
            return -1;
        }

        public void push_back(int value) {
            if(!deque.isEmpty()){
                if(deque.getFirst()>value){
                    deque.addLast(value);
                }else{
                    removed += deque.size();
                    queue.addAll(deque);
                    deque.clear();
                    deque.addLast(value);
                }
            }else{
                deque.addLast(value);
            }
        }

        public int pop_front() {
            if(queue.isEmpty() && deque.isEmpty())
                return -1;
            if(removed==0){
                int maxVal = Integer.MIN_VALUE;
                removed++;
                queue.add(deque.removeFirst());
                for(Integer value:deque)
                    maxVal = Math.max(maxVal,value);
                while(!deque.isEmpty()){
                    if(deque.getFirst()==maxVal)
                        break;
                    removed++;
                    maxVal = Math.max(deque.getFirst(),maxVal);
                    queue.add(deque.removeFirst());
                }
            }
            removed-=1;
            return queue.remove();
        }
    }
}
