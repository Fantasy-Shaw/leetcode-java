package org.example.solutions.leetcode3k;

import java.util.TreeSet;

public class Solution3093 {
    class Solution {
        TrieNode root;

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            root = new TrieNode();
            for (int i = 0; i < wordsContainer.length; i++) {
                add(wordsContainer[i], i);
            }
            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                ans[i] = query(wordsQuery[i]);
            }
            return ans;
        }

        private void add(String s, int idx) {
            root.props.add(new int[]{s.length(), idx});
            TrieNode tr = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
                tr.props.add(new int[]{s.length(), idx});
            }
        }

        private int query(String s) {
            TrieNode tr = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    break;
                }
                tr = tr.children[u];
            }
            return tr.props.first()[1];
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            // int[2] : length, idx
            TreeSet<int[]> props = new TreeSet<>(
                    (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );
        }
    }
}