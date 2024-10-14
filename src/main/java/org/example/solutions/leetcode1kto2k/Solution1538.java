package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1538 {
    interface ArrayReader {
        // Compares 4 different elements in the array
        // return 4 if the values of the 4 elements are the same (0 or 1).
        // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
        // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
        int query(int a, int b, int c, int d);

        // Returns the length of the array
        int length();
    }

    class Solution {
        private boolean[] arr;
        private int n;
        private ArrayReader reader;

        public int guessMajority(ArrayReader reader) {
            this.reader = reader;
            n = reader.length();
            arr = new boolean[n];
            arr[0] = true;
            for (int i = 1; i < n; i++) {
                arr[i] = checkIfSame(0, i);
            }
            int sum = 0;
            for (var i : arr) {
                if (i) sum++;
            }
            if (sum * 2 == n) return -1;
            return sum * 2 < n ? findElemIdx(0) : findElemIdx(1);
        }

        private boolean checkIfSame(int p, int q) {
            List<Integer> listP = new ArrayList<>(), listQ = new ArrayList<>();
            listP.add(p);
            listQ.add(q);
            for (int i = 0; i < n; i++) {
                if (i != p && i != q) {
                    listP.add(i);
                    listQ.add(i);
                }
                if (listP.size() == 4) break;
            }
            Collections.sort(listP);
            Collections.sort(listQ);
            return reader.query(listP.get(0), listP.get(1), listP.get(2), listP.get(3))
                    == reader.query(listQ.get(0), listQ.get(1), listQ.get(2), listQ.get(3));
        }

        private int findElemIdx(int num) {
            for (int i = 0; i < arr.length; i++) {
                if (num == (arr[i] ? 1 : 0)) return i;
            }
            return -1;
        }
    }
}