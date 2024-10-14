package org.example.solutions.leetcode1to200;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> vis = new HashMap<>();
            return dfs(head, vis);
        }

        private Node dfs(Node head, Map<Node, Node> vis) {
            if (head == null) {
                return head;
            }
            if (vis.containsKey(head)) {
                return vis.get(head);
            }
            Node node = new Node(head.val);
            vis.put(head, node);
            node.next = dfs(head.next, vis);
            node.random = dfs(head.random, vis);
            return node;
        }
    }
}