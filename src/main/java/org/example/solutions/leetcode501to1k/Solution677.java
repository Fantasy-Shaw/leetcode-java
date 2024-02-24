package org.example.solutions.leetcode501to1k;

public class Solution677 {
    class MapSum {
        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode.add(root, key, val);
        }

        public int sum(String prefix) {
            return TrieNode.query(root, prefix);
        }
    }

    static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int sum = 0;

        public static void add(TrieNode root, String s, int val) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
            }
            tr.sum = val; // replace
        }

        public static int query(TrieNode root, String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    return 0;
                }
                tr = tr.children[u];
            }
            return dfs(tr);
        }

        public static int dfs(TrieNode node) {
            int ans = node.sum;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    ans += dfs(node.children[i]);
                }
            }
            return ans;
        }
    }
}