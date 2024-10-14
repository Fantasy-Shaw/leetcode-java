package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {
    class Solution {
        private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private TrieNode root;
        private boolean[][] vis;
        private int m, n;
        private char[][] board;
        private Set<String> set;

        public List<String> findWords(char[][] board, String[] words) {
            root = new TrieNode();
            m = board.length;
            n = board[0].length;
            vis = new boolean[m][n];
            this.board = board;
            set = new HashSet<>();
            for (var s : words) insert(s);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int u = board[i][j] - 'a';
                    if (root.children[u] != null) {
                        vis[i][j] = true;
                        dfs(i, j, root.children[u]);
                        vis[i][j] = false;
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private void dfs(int i, int j, TrieNode node) {
            if (node.s != null) set.add(node.s);
            for (var d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (vis[x][y]) continue;
                int u = board[x][y] - 'a';
                if (node.children[u] != null) {
                    vis[x][y] = true;
                    dfs(x, y, node.children[u]);
                    vis[x][y] = false;
                }
            }
        }

        private void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.children[u] == null) p.children[u] = new TrieNode();
                p = p.children[u];
            }
            p.s = s;
        }

        private static class TrieNode {
            public String s;
            public TrieNode[] children = new TrieNode[26];
        }
    }
}