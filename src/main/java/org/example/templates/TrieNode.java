package org.example.templates;

import java.util.*;

public class TrieNode {
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

    public static void addRevStr(TrieNode root, String s) {
        TrieNode tr = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            int u = s.charAt(i) - 'a';
            if (tr.children[u] == null) {
                tr.children[u] = new TrieNode();
            }
            tr = tr.children[u];
        }
        tr.isEnd = true;
    }

    public static boolean query(TrieNode root, String s) {
        TrieNode tr = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr.children[u] == null) {
                return false;
            }
            tr = tr.children[u];
        }
        return tr.isEnd;
    }

    public static List<String> queryPrefix(TrieNode root, String prefix) {
        List<String> ans = new ArrayList<>();
        TrieNode tr = root;
        if (tr.isEnd) return ans;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (tr.children[u] == null) {
                return ans;
            }
            tr = tr.children[u];
        }
        StringBuilder sb = new StringBuilder(prefix);
        queryPrefixHelper(ans, tr, sb);
        return ans;
    }

    private static void queryPrefixHelper(List<String> ans, TrieNode tr, StringBuilder sb) {
        if (tr.isEnd) {
            ans.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (tr.children[i] != null) {
                sb.append((char) ('a' + i));
                queryPrefixHelper(ans, tr.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
