package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution820 {
    class Solution {
        TrieNode root;

        public int minimumLengthEncoding(String[] words) {
            root = new TrieNode();
            List<String> rev = new ArrayList<>();
            for (var w : words) {
                rev.add(new StringBuilder(w).reverse().toString());
            }
            // build trie with reversed order
            rev.sort((a, b) -> b.length() - a.length());
            int ans = 0;
            for (var s : rev) {
                if (!check(s)) {
                    add(s);
                    // Needs "word#"
                    ans += s.length() + 1;
                }
            }
            return ans;
        }

        private boolean check(String revS) {
            TrieNode cur = root;
            for (int i = 0; i < revS.length(); i++) {
                int u = revS.charAt(i) - 'a';
                if (cur.children[u] == null) return false;
                cur = cur.children[u];
            }
            return true;
        }

        private void add(String revS) {
            TrieNode cur = root;
            for (int i = 0; i < revS.length(); i++) {
                int u = revS.charAt(i) - 'a';
                if (cur.children[u] == null) {
                    cur.children[u] = new TrieNode();
                }
                cur = cur.children[u];
            }
            cur.isEnd = true;
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
    }
}