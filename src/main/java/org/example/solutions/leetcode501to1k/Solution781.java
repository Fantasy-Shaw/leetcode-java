package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Arrays.sort(answers);
            int n = answers.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int cnt = answers[i];
                ans += (cnt + 1);
                for (int j = 0; j < cnt; j++) {
                    if (i < n - 1 && answers[i] == answers[i + 1]) {
                        i++;
                    }
                }
            }
            return ans;
        }
    }
}