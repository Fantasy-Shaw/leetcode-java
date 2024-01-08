package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution316 {
    class Solution {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }
            StringBuilder monoSt = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!vis[c - 'a']) {
                    while (!monoSt.isEmpty() && monoSt.charAt(monoSt.length() - 1) > c) {
                        if (num[monoSt.charAt(monoSt.length() - 1) - 'a'] > 0) {
                            vis[monoSt.charAt(monoSt.length() - 1) - 'a'] = false;
                            monoSt.deleteCharAt(monoSt.length() - 1);
                        } else {
                            break;
                        }
                    }
                    vis[c - 'a'] = true;
                    monoSt.append(c);
                }
                num[c - 'a']--;
            }
            return monoSt.toString();
        }
    }
}