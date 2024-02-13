package org.example.solutions.leetcode201to500;

public class Solution468 {
    class Solution {
        static final String[] ans = {"Neither", "IPv4", "IPv6"};

        public String validIPAddress(String queryIP) {
            if (queryIP == null || queryIP.isEmpty()) {
                return ans[0];
            }
            String uint8 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
            String ipv4 = String.format("%s(\\.%s){3}", uint8, uint8);
            String uint16 = "[\\da-fA-F]{1,4}";
            String ipv6 = String.format("%s(:%s){7}", uint16, uint16);
            if (queryIP.matches(ipv4)) {
                return ans[1];
            } else if (queryIP.matches(ipv6)) {
                return ans[2];
            } else {
                return ans[0];
            }
        }
    }
}