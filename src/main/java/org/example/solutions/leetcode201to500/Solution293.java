package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution293 {
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < currentState.length(); i++) {
                if (currentState.charAt(i - 1) == '+' && currentState.charAt(i) == '+') {
                    ans.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1));
                }
            }
            return ans;
        }
    }
}