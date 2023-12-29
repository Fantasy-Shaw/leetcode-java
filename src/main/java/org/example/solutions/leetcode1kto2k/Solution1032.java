package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1032 {
    class StreamChecker {
        private TrieNode tr;
        private StringBuilder sb;

        public StreamChecker(String[] words) {
            tr = new TrieNode();
            sb = new StringBuilder();
            for (var word : words) {
                add(word);
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            int min = Math.max(0, sb.length() - 200);
            TrieNode t = tr;
            for (int i = sb.length() - 1; i >= min; i--) {
                if (t.isEnd) return true;
                int u = sb.charAt(i) - 'a';
                if (t.children[u] == null) return false;
                t = t.children[u];
            }
            return t.isEnd;
        }

        private void add(String s) {
            // reversed
            TrieNode t = tr;
            for (int i = s.length() - 1; i >= 0; i--) {
                int u = s.charAt(i) - 'a';
                if (t.children[u] == null) t.children[u] = new TrieNode();
                t = t.children[u];
            }
            t.isEnd = true;
        }

        private static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isEnd = false;
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
}