package org.example.solutions.leetcode201to500;

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