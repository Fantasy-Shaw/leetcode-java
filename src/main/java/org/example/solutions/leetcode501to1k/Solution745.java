package org.example.solutions.leetcode501to1k;

import org.example.templates.TrieNode;

import java.util.*;

public class Solution745 {
    class WordFilter {
        private TrieNode root, rootRev;

        public WordFilter(String[] words) {
            root = new TrieNode();
            rootRev = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                add(words[i], i);
                addRev(words[i], i);
            }
        }

        public int f(String pref, String suff) {
            int n = pref.length(), m = suff.length();
            TrieNode tr = root;
            for (int i = 0; i < n; i++) {
                int u = pref.charAt(i) - 'a';
                if (tr.children[u] == null) return -1;
                tr = tr.children[u];
            }
            List<Integer> list1 = tr.indices;
            tr = rootRev;
            for (int i = m - 1; i >= 0; i--) {
                int u = suff.charAt(i) - 'a';
                if (tr.children[u] == null) return -1;
                tr = tr.children[u];
            }
            List<Integer> list2 = tr.indices;
            for (int i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; ) {
                if (list1.get(i) > list2.get(j)) i--;
                else if (list1.get(i) < list2.get(j)) j--;
                else return list1.get(i);
            }
            return -1;
        }

        private void add(String s, int idx) {
            int n = s.length();
            root.indices.add(idx);
            TrieNode tr = root;
            for (int i = 0; i < n; i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
                tr.indices.add(idx);
            }
        }

        private void addRev(String s, int idx) {
            root.indices.add(idx);
            TrieNode tr = rootRev;
            for (int i = s.length() - 1; i >= 0; i--) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
                tr.indices.add(idx);
            }
        }

        private static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public List<Integer> indices = new ArrayList<>();
        }
    }

    class WordFilter2 {
        Map<String, Integer> dictionary;

        public WordFilter2(String[] words) {
            dictionary = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int m = word.length();
                for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                    for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                        dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return dictionary.getOrDefault(pref + "#" + suff, -1);
        }
    }

    class WordFilter1 {
        private TrieNode root;
        private Map<String, Integer> word2Idx;

        public WordFilter1(String[] words) {
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