package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution269 {
    class Solution {
        // Topological sort + dfs
        private static final int VISITING = 1, VISITED = 2;
        private Map<Character, List<Character>> edges;
        private Map<Character, Integer> states;
        private boolean valid;
        private char[] order;
        private int index;

        public String alienOrder(String[] words) {
            edges = new HashMap<>();
            states = new HashMap<>();
            valid = true;
            for (var word : words) {
                for (int j = 0; j < word.length(); j++) {
                    edges.putIfAbsent(word.charAt(j), new ArrayList<>());
                }
            }
            for (int i = 1; i < words.length && valid; i++) {
                addEdge(words[i - 1], words[i]);
            }
            order = new char[edges.size()];
            index = edges.size() - 1;
            for (char u : edges.keySet()) {
                if (!states.containsKey(u)) {
                    dfs(u);
                }
            }
            if (!valid) {
                return "";
            }
            return new String(order);
        }

        private void addEdge(String pre, String post) {
            int len = Math.min(pre.length(), post.length());
            int index = 0;
            while (index < len) {
                char c1 = pre.charAt(index), c2 = post.charAt(index);
                if (c1 != c2) {
                    edges.get(c1).add(c2);
                    break;
                }
                index++;
            }
            if (index == len && pre.length() > post.length()) {
                valid = false;
            }
        }

        private void dfs(char u) {
            states.put(u, VISITING);
            for (char v : edges.get(u)) {
                if (!states.containsKey(v)) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (states.get(v) == VISITING) {
                    valid = false;
                    return;
                }
            }
            states.put(u, VISITED);
            order[index] = u;
            index--;
        }
    }
}