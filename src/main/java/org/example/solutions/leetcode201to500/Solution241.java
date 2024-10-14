package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            if (expression == null || expression.isEmpty()) {
                return new ArrayList<>();
            }
            char[] cs = expression.toCharArray();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < cs.length; i++) {
                char ch = cs[i];
                if (!Character.isDigit(ch)) {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (var l : left) {
                        for (var r : right) {
                            if (ch == '+') {
                                ans.add(l + r);
                            } else if (ch == '-') {
                                ans.add(l - r);
                            } else {
                                ans.add(l * r);
                            }
                        }
                    }
                }
            }
            if (ans.isEmpty()) {
                ans.add(Integer.parseInt(expression));
            }
            return ans;
        }
    }
}