package org.example.solutions.LCR;

import java.util.*;

public class P109 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> qu = new ArrayDeque<>();
            Set<String> vis = new HashSet<>(), dead = new HashSet<>(Arrays.asList(deadends));
            String start = "0000";
            if (dead.contains(start) || dead.contains(target)) {
                return -1;
            }
            if (start.equals(target)) {
                return 0;
            }
            qu.offer(start);
            vis.add(start);
            int ans = 0;
            while (!qu.isEmpty()) {
                ans++;
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    char[] s = qu.poll().toCharArray();
                    for (int j = 0; j < 4; j++) {
                        char t = s[j];
                        s[j] = pre(t);
                        String s1 = new String(s);
                        if (s1.equals(target)) {
                            return ans;
                        }
                        if (!vis.contains(s1) && !dead.contains(s1)) {
                            vis.add(s1);
                            qu.offer(s1);
                        }
                        s[j] = next(t);
                        String s2 = new String(s);
                        if (s2.equals(target)) {
                            return ans;
                        }
                        if (!vis.contains(s2) && !dead.contains(s2)) {
                            vis.add(s2);
                            qu.offer(s2);
                        }
                        s[j] = t;
                    }
                }
            }
            return -1;
        }

        private char pre(char ch) {
            return ch == '0' ? '9' : (char) (ch - 1);
        }

        private char next(char ch) {
            return ch == '9' ? '0' : (char) (ch + 1);
        }
    }
}