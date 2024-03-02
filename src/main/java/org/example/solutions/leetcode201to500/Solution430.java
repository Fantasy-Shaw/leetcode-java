package org.example.solutions.leetcode201to500;

public class Solution430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return head;
            }
            dfs(head);
            return head;
        }

        public Node dfs(Node head) {
            Node tail = head;
            Node cur = head;
            while (cur != null) {
                if (cur.child != null) {
                    Node nextNode = cur.next;
                    Node childTail = dfs(cur.child);
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                    if (childTail != null) childTail.next = nextNode;
                    if (nextNode != null) nextNode.prev = childTail;
                    tail = cur;
                    cur = childTail;
                } else {
                    tail = cur;
                    cur = cur.next;
                }
            }
            return tail;
        }
    }
}