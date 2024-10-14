package org.example.solutions.leetcode1kto2k;

public class Solution1533 {
    interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        public int compareSub(int l, int r, int x, int y);

        // Returns the length of the array
        public int length();
    }

    class Solution {
        private ArrayReader reader;

        public int getIndex(ArrayReader reader) {
            this.reader = reader;
            int len = reader.length();
            return helper(0, len / 2 - 1, len - len / 2, len - 1);
        }

        private int helper(int l, int r, int x, int y) {
            int value = reader.compareSub(l, r, x, y);
            if (value > 0) {
                if (l == r) {
                    return l;
                }
                int n = r - l + 1;
                return helper(l, l + n / 2 - 1, r - n / 2 + 1, r);
            } else if (value < 0) {
                if (x == y) {
                    return x;
                }
                int n = y - x + 1;
                return helper(x, x + n / 2 - 1, y - n / 2 + 1, y);
            } else {
                return r + 1;
            }
        }
    }
}