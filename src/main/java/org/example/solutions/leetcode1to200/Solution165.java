package org.example.solutions.leetcode1to200;

public class Solution165 {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int n = Math.min(v1.length, v2.length);
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(v1[i]), y = Integer.parseInt(v2[i]);
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                }
            }
            if (v1.length != v2.length) {
                String[] v = (v1.length > v2.length) ? v1 : v2;
                for (int i = n; i < v.length; i++) {
                    if (Integer.parseInt(v[i]) != 0) {
                        return v1.length > v2.length ? 1 : -1;
                    }
                }
            }
            return 0;
        }
    }
}