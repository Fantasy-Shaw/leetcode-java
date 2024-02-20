package org.example.solutions.leetcode3k;

public class Solution3043 {
    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            TrieNode root = new TrieNode();
            for (int i : arr2) {
                add(root, String.valueOf(i));
            }
            int mx = 0;
            for (int i : arr1) {
                mx = Math.max(query(root, String.valueOf(i)), mx);
            }
            return mx;
        }

        static class TrieNode {
            public TrieNode[] children = new TrieNode[10];
            public boolean isEnd = false;
        }

        public static void add(TrieNode root, String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - '0';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
            }
            tr.isEnd = true;
        }

        public static int query(TrieNode root, String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - '0';
                if (tr.children[u] == null) {
                    return i;
                }
                tr = tr.children[u];
            }
            return s.length();
        }
    }
}