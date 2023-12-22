package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution179 {
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int n : nums) {
                list.add(String.valueOf(n));
            }
            list.sort((a, b) -> (b + a).compareTo(a + b));
            StringBuilder sb = new StringBuilder();
            for (String n : list) {
                sb.append(n);
            }
            int n = list.size(), i = 0;
            while (i < n - 1 && sb.charAt(i) == '0') i++;
            return sb.substring(i);
        }
    }
}