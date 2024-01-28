package org.example.solutions.leetcode200to1k;

public class Solution904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            int f1 = fruits[0], f2 = -1;
            int i1r = 0, i2r = 0;
            int pre = 0, ans = 0, i = 1;
            for (; i < fruits.length; i++) {
                int cur = fruits[i];
                if (cur == f1) {
                    i1r = i;
                } else if (cur == f2) {
                    i2r = i;
                } else if (f2 == -1) {
                    f2 = cur;
                    i2r = i;
                } else {
                    ans = Math.max(i - pre, ans);
                    if (i1r < i2r) {
                        pre = i1r + 1;
                        f1 = f2;
                        f2 = cur;
                        i1r = i2r;
                        i2r = i;
                    } else {
                        pre = i2r + 1;
                        f2 = f1;
                        f1 = cur;
                        i2r = i1r;
                        i1r = i;
                    }
                }
            }
            ans = Math.max(ans, i - pre);
            return ans;
        }
    }
}