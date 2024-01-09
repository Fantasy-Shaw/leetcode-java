package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1087 {
    class Solution {
        private List<String> ans;
        private String s;
        private StringBuilder sb;

        public String[] expand(String s) {
            s = s.replaceAll(",", "");
            if (s.indexOf('{') < 0) return new String[]{s};
            this.s = s;
            this.sb = new StringBuilder();
            ans = new ArrayList<>();
            dfs(0);
            ans.sort(String::compareTo);
            return ans.toArray(new String[ans.size()]);
        }

        private void dfs(int idx) {
            if (idx == s.length()) {
                ans.add(sb.toString());
                return;
            }
            if (s.charAt(idx) == '{') {
                int cnt = 0;
                for (int j = idx + 1; j < s.length() && s.charAt(j) != '}'; j++) {
                    cnt++;
                }
                for (int j = idx + 1; j < s.length() && s.charAt(j) != '}'; j++) {
                    char ch = s.charAt(j);
                    sb.append(ch);
                    dfs(idx + cnt + 2);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(idx));
                dfs(idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}