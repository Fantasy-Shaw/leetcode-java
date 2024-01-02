package org.example.solutions.leetcode200to1k;

import org.example.templates.TrieNode;

import java.util.*;

public class Solution745 {
    class WordFilter {
        private TrieNode root;
        private Map<String, Integer> word2Idx;

        public WordFilter(String[] words) {
            root = new TrieNode();
            word2Idx = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                word2Idx.put(words[i], i);
                TrieNode.add(root, words[i]);
            }
        }

        public int f(String pref, String suff) {
            Set<String> set = new HashSet<>(TrieNode.queryPrefix(root, pref));
            List<String> list = new ArrayList<>(set);
            for (String s : list) {
                if (!s.endsWith(suff)) {
                    set.remove(s);
                }
            }
            int ans = -1;
            for (String str : set) {
                ans = Math.max(ans, word2Idx.get(str));
            }
            return ans;
        }
    }
}