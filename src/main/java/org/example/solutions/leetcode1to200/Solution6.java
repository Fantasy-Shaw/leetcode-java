package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution6 {
    class Solution {
        public String convert(String s, int numRows) {
            // int[3] : [x,y,code]
            List<int[]> chs = new ArrayList<>();
            int i = 0, n = s.length();
            int x = 0;
            loopOutput:
            while (true) {
                for (int y = 0; y < numRows; y++) {
                    char ch = s.charAt(i);
                    chs.add(new int[]{x, y, ch});
                    if (++i == n) {
                        break loopOutput;
                    }
                }
                x++;
                for (int y = numRows - 2; y >= 1; x++, y--) {
                    char ch = s.charAt(i);
                    chs.add(new int[]{x, y, ch});
                    if (++i == n) {
                        break loopOutput;
                    }
                }
                x++;
            }
            chs.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            StringBuilder ans = new StringBuilder();
            for (var it : chs) {
                ans.append((char) it[2]);
            }
            return ans.toString();
        }
    }
}