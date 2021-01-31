import leetcode.ListNode;
import leetcode.Node;
import leetcode.SwordTowardOffer;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 35 复杂链表的复制
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Integer> old_Nodes = new HashMap<>();
        HashMap<Node, Node> reflect = new HashMap<>();
        Node tmp = new Node(-1), res = tmp;
        while (head != null) {
            if (old_Nodes.containsKey(head)) {
                tmp.next = reflect.get(head);
                old_Nodes.put(head, 1);
                reflect.put(head, tmp.next);
            } else {
                old_Nodes.put(head, 1);
                Node newNode = new Node(head.val);
                tmp.next = newNode;
                reflect.put(head, tmp.next);
                Node tmpHead = head;
                while (tmpHead.random != null) {
                    if (old_Nodes.containsKey(tmpHead.random)) {
                        newNode.random = reflect.get(tmpHead.random);
                        break;
                    } else {
                        Node node = new Node(tmpHead.random.val);
                        newNode.random = node;
                        old_Nodes.put(tmpHead.random, 1);
                        reflect.put(tmpHead.random, node);
                        tmpHead = tmpHead.random;
                        newNode = node;
                    }
                }
            }
            tmp = tmp.next;
            head = head.next;
        }
        return res.next;
    }


    public Node copyRandomList_better(Node head) {
        if (head == null)
            return head;
        Node tmp = head;
        while (tmp != null) {
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = tmp.next.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        Node res = new Node(-1), nextTmp, resTmp = res;
        tmp = head;
        while (tmp != null) {
            nextTmp = tmp.next.next;
            resTmp.next = tmp.next;
            tmp.next = nextTmp;
            tmp = tmp.next;
            resTmp = resTmp.next;
        }
        return res.next;
    }
}
