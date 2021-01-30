import leetcode.ListNode;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 30 包含min函数的栈
    class MinStack {

        SwordTowardOffer.MinStack.StackNode head,tail,minHead,minTail;

        class StackNode{
            int val;
            SwordTowardOffer.MinStack.StackNode next,pre;

            public StackNode() {
            }

            public StackNode(int val) {
                this.val = val;
            }
        }

        /** initialize your data structure here. */
        public MinStack() {
            head = new SwordTowardOffer.MinStack.StackNode();
            minHead = new SwordTowardOffer.MinStack.StackNode(Integer.MIN_VALUE);
            tail = head;
            minTail = minHead;
        }

        public void push(int x) {
            SwordTowardOffer.MinStack.StackNode newNode = new SwordTowardOffer.MinStack.StackNode(x);
            tail.next = newNode;
            newNode.pre = tail;
            tail = tail.next;
            SwordTowardOffer.MinStack.StackNode newMinNode = new SwordTowardOffer.MinStack.StackNode(Math.min(x,minTail.val));
            minTail.next = newMinNode;
            newMinNode.pre = minTail;
            minTail = newMinNode;
        }

        public void pop() {
            tail = tail.pre;
            tail.next = null;
            minTail =minTail.pre;
            minTail.next = null;
        }

        public int top() {
            return tail.val;
        }

        public int min() {
            return minTail.val;
        }
    }
}
