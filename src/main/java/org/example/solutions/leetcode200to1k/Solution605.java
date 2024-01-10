package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution605 {
    class StringIterator {
        private final Queue<Pair<Character, Integer>> unCompressedString;

        public StringIterator(String compressedString) {
            unCompressedString = new ArrayDeque<>();
            int i = 0, j;
            while (i < compressedString.length()) {
                char ch = compressedString.charAt(i);
                i++;
                j = i;
                while (j < compressedString.length()
                        && Character.isDigit(compressedString.charAt(j))) {
                    j++;
                }
                int n = (i == j) ? 1 : Integer.parseInt(compressedString.substring(i, j));
                unCompressedString.offer(new Pair<>(ch, n));
                i = j;
            }
        }

        public char next() {
            if (!unCompressedString.isEmpty()) {
                char ch = unCompressedString.peek().first;
                if (--unCompressedString.peek().second == 0) {
                    unCompressedString.poll();
                }
                return ch;
            }
            return ' ';
        }

        public boolean hasNext() {
            return !unCompressedString.isEmpty();
        }

        private static class Pair<_Tp1, _Tp2> {
            _Tp1 first;
            _Tp2 second;

            Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}