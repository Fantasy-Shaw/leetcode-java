package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1506 {
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
        public Node findRoot(List<Node> tree) {
            Map<Node, Boolean> isRoot = new HashMap<>();
            for (Node node : tree) {
                isRoot.putIfAbsent(node, true);
                for (Node child : node.children) {
                    isRoot.put(child, false);
                }
            }
            for (var kv : isRoot.entrySet()) {
                if (kv.getValue()) {
                    return kv.getKey();
                }
            }
            return null;
        }
    }
}
