package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution648 {
    class Solution {
        TrieNode root;

        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();
            for (var s : dictionary) {
                add(s);
            }
            StringBuilder ans = new StringBuilder();
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                int rootLen = getRootLen(words[i]);
                ans.append(rootLen == 0 ? words[i] : words[i].substring(0, rootLen));
                if (i < words.length - 1) ans.append(' ');
            }
            return ans.toString();
        }

        private void add(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (cur.children[u] == null) {
                    cur.children[u] = new TrieNode();
                }
                cur = cur.children[u];
            }
            cur.isEnd = true;
        }

        private int getRootLen(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                if (cur.isEnd) {
                    return i;
                }
                int u = s.charAt(i) - 'a';
                if (cur.children[u] == null) {
                    break;
                }
                cur = cur.children[u];
            }
            return 0;
        }

        static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isEnd = false;
        }
    }
}