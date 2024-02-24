package org.example.solutions.leetcode501to1k;

public class Solution676 {
    class MagicDictionary {
        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (var word : dictionary) {
                TrieNode.add(root, word);
            }
        }

        public boolean search(String searchWord) {
            return TrieNode.query(root, searchWord, 0, 1);
        }
    }

    static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd = false;

        public static void add(TrieNode root, String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
            }
            tr.isEnd = true;
        }

        public static boolean query(TrieNode node, String s, int cur, int lim) {
            if (lim < 0) {
                return false;
            }
            if (cur == s.length()) {
                return node.isEnd && (lim == 0);
            }
            TrieNode tr = node;
            boolean ans = false;
            for (int i = cur; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (lim > 0) {
                    for (int v = 0; v < 26; v++) {
                        if (v == u || tr.children[v] == null) continue;
                        ans |= query(tr.children[v], s, i + 1, lim - 1);
                    }
                }
                if (tr.children[u] == null) {
                    return ans;
                }
                tr = tr.children[u];
            }
            return ans || (tr.isEnd && (lim == 0));
        }
    }
}