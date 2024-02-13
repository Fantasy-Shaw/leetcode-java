package org.example.solutions.leetcode501to1k;

public class Solution670 {
    class Solution {
        public int maximumSwap(int num) {
            char[] cs = String.valueOf(num).toCharArray();
            int idxOfMxVal = cs.length - 1;
            int small = -1, large = -1;
            for (int i = cs.length - 2; i >= 0; i--) {
                if (cs[i] > cs[idxOfMxVal]) {
                    idxOfMxVal = i;
                } else if (cs[i] < cs[idxOfMxVal]) {
                    small = i;
                    large = idxOfMxVal;
                }
            }
            if (small == -1) { // cs is desc
                return num;
            }
            var t = cs[small];
            cs[small] = cs[large];
            cs[large] = t;
            return Integer.parseInt(new String(cs));
        }
    }
}