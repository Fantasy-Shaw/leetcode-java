package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    class Solution1 {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            for (int i = 0; i < n; i++) {
                int m = ans.size();
                for (int j = m - 1; j >= 0; j--) {
                    ans.set(j, ans.get(j) << 1);
                    ans.add(ans.get(j) + 1);
                }
            }
            return ans;
        }
    }

    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>(20);
            int m = 1 << n;
            for (int i = 0; i < m; i++) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }
    }
}