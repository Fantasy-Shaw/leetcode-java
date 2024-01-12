package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2645 {
    class Solution {
        public int addMinimum(String word) {
            int abc_nums = 1;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i - 1) >= word.charAt(i)) {
                    abc_nums++;
                }
            }
            return abc_nums * 3 - word.length();
        }
    }
}