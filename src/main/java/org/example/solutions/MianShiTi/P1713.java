package org.example.solutions.MianShiTi;

import org.example.templates.TrieNode;

import java.util.Arrays;

public class P1713 {
    class Solution {
        TrieNode root;

        public int respace(String[] dictionary, String sentence) {
            int n = sentence.length();
            root = new TrieNode();
            char[] cs = sentence.toCharArray();
            for (var word : dictionary) {
                TrieNode.addRevStr(root, word);
            }
            int[] f = new int[n + 1];
            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = 0;
            for (int i = 1; i <= n; i++) {
                f[i] = f[i - 1] + 1;
                TrieNode t = root;
                for (int j = i; j >= 1; j--) {
                    int u = cs[j - 1] - 'a';
                    if (t.children[u] == null) {
                        break;
                    } else if (t.children[u].isEnd) {
                        f[i] = Math.min(f[i], f[j - 1]);
                    }
                    if (f[i] == 0) {
                        break;
                    }
                    t = t.children[u];
                }
            }
            return f[n];
        }
    }
}