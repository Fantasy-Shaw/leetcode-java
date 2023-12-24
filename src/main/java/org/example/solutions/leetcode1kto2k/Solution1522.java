package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1522 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        // Pre: Leetcode-543
        private int ans;

        public int diameter(Node root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        private int depth(Node root) {
            if (root == null) {
                return 0;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (Node child : root.children) {
                pq.offer(depth(child));
            }
            int n1 = 0, n2 = 0;
            if (pq.size() >= 2) {
                n1 = pq.poll();
                n2 = pq.poll();
            } else if (pq.size() == 1) {
                n1 = pq.poll();
            }
            ans = Math.max(ans, n1 + n2 + 1);
            return n1 + 1;
        }
    }
}