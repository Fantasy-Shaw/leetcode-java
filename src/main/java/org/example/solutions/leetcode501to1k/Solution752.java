package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution752 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadSet = new HashSet<>(), vis = new HashSet<>();
            for (var d : deadends) {
                deadSet.add(d);
            }
            String start = "0000";
            if (deadSet.contains(start)) {
                return -1;
            }
            Queue<String> qu = new LinkedList<>();
            qu.offer(start);
            vis.add(start);
            int ans = 0;
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int x = 0; x < m; x++) {
                    String cur = qu.poll();
                    if (cur.equals(target)) {
                        return ans;
                    }
                    char[] cs = cur.toCharArray();
                    for (int i = 0; i < 4; i++) {
                        char t = cs[i];
                        cs[i] = prev(t);
                        String next1 = new String(cs);
                        if (!vis.contains(next1) && !deadSet.contains(next1)) {
                            qu.offer(next1);
                            vis.add(next1);
                        }
                        cs[i] = next(t);
                        String next2 = new String(cs);
                        if (!vis.contains(next2) && !deadSet.contains(next2)) {
                            qu.offer(next2);
                            vis.add(next2);
                        }
                        cs[i] = t;
                    }
                }
                ans++;

            }
            return -1;
        }

        private static char prev(char ch) {
            return ch == '0' ? '9' : (char) (ch - 1);
        }

        private static char next(char ch) {
            return ch == '9' ? '0' : (char) (ch + 1);
        }
    }
}