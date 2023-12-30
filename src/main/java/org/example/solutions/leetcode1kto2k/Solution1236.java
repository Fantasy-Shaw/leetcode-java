package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1236 {
    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    class Solution {
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            Queue<String> qu = new ArrayDeque<>();
            Set<String> set = new HashSet<>();
            set.add(startUrl);
            qu.add(startUrl);
            while (!qu.isEmpty()) {
                String curUrl = qu.poll();
                for (String nextUrl : htmlParser.getUrls(curUrl)) {
                    if (!set.contains(nextUrl) && getHostname(nextUrl).equals(getHostname(curUrl))) {
                        set.add(nextUrl);
                        qu.add(nextUrl);
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private static String getHostname(String url) {
            String hostname = url.startsWith("https://") ? url.substring(8) : url.substring(7);
            return hostname.contains("/") ? hostname.substring(0, hostname.indexOf('/')) : hostname;
        }
    }
}