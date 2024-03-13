package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            List<Integer> ip = new ArrayList<>(4);
            dfs(ans, s, 0, ip);
            return ans;
        }

        private void dfs(List<String> ans, String s, int i, List<Integer> ip) {
            if (ip.size() == 4) {
                if (i == s.length()) {
                    ans.add(ip.getFirst() + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
                }
                return;
            }
            if (i + 1 <= s.length()) {
                int d1 = Integer.parseInt(s.substring(i, i + 1));
                if (d1 == 0) {
                    ip.add(0);
                    dfs(ans, s, i + 1, ip);
                    ip.removeLast();
                } else {
                    ip.add(d1);
                    dfs(ans, s, i + 1, ip);
                    ip.removeLast();
                }
            }
            if (i + 2 <= s.length()) {
                String s2 = s.substring(i, i + 2);
                if (s2.charAt(0) != '0') { // No leading zeros
                    int d2 = Integer.parseInt(s2);
                    ip.add(d2);
                    dfs(ans, s, i + 2, ip);
                    ip.removeLast();
                }
            }
            if (i + 3 <= s.length()) {
                String s3 = s.substring(i, i + 3);
                if (s3.charAt(0) != '0') { // No leading zeros
                    int d3 = Integer.parseInt(s3);
                    if (d3 <= 255) {
                        ip.add(d3);
                        dfs(ans, s, i + 3, ip);
                        ip.removeLast();
                    }
                }
            }
        }
    }
}