package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.List;

public class Solution2778 {
    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            String sep = "\\" + separator;
            List<String> ans = new ArrayList<>();
            for (String str : words) {
                String[] ss = str.split(sep);
                for (String s : ss) {
                    if (!s.isEmpty()) {
                        ans.add(s);
                    }
                }
            }
            return ans;
        }
    }
}
