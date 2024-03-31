package org.example.solutions.leetcode201to500;

public class Solution331 {
    class Solution {
        public boolean isValidSerialization(String preorder) {
            /**
             * cntNum = cntSharp - 1
             * before the end : cntNum >= cntSharp ==> the last must be '#'
             */
            int cntNum = 0, cntSharp = 0;
            String[] nodes = preorder.split(",");
            int n = nodes.length;
            for (int i = 0; i < n - 1; i++) {
                if (nodes[i].equals("#")) {
                    cntSharp++;
                } else {
                    cntNum++;
                }
                if (cntNum < cntSharp) {
                    return false;
                }
            }
            if (nodes[n - 1].equals("#")) {
                cntSharp++;
            } else {
                return false;
            }
            return cntNum == cntSharp - 1;
        }
    }
}