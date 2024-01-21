package org.example.solutions.leetcode1kto2k;

import org.example.templates.UnionFind;

import java.util.*;

public class Solution1061 {
    class Solution {
        static final int maxN = 1050;

        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UnionFind uf = new UnionFind(maxN);
            int m = s1.length();
            for (int i = 0; i < m; i++) {
                char a = s1.charAt(i), b = s2.charAt(i);
                uf.union(a, b);
            }
            char[] map = new char[128];
            for (int i = 'a'; i <= 'z'; i++) {
                map[i] = (char) i;
                for (int j = 'a'; j < i; j++) {
                    if (uf.isConnected(i, j)) {
                        map[i] = (char) j;
                        break;
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            for (char ch : baseStr.toCharArray()) {
                ans.append(map[ch]);
            }
            return ans.toString();
        }
    }
}