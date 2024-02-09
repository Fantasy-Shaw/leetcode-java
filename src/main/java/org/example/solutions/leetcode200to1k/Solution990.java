package org.example.solutions.leetcode200to1k;

import org.example.templates.UnionFind;

public class Solution990 {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind uf = new UnionFind(26);
            for (var eq : equations) {
                char op = eq.charAt(1);
                if (op == '=') {
                    int u = eq.charAt(0) - 'a';
                    int v = eq.charAt(3) - 'a';
                    uf.union(u, v);
                }
            }
            for (var eq : equations) {
                char op = eq.charAt(1);
                if (op == '!') {
                    int u = eq.charAt(0) - 'a';
                    int v = eq.charAt(3) - 'a';
                    if (uf.isConnected(u, v)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}