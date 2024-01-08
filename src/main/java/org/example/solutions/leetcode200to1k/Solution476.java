package org.example.solutions.leetcode200to1k;

public class Solution476 {
    class Solution {
        public int findComplement(int num) {
//        int x = 0;
//        for (int i = num; i != 0; i -= (i & -i)) {
//            x = i;
//        }
            int x = Integer.highestOneBit(num);
            return ~num & (x - 1);
        }
    }
}