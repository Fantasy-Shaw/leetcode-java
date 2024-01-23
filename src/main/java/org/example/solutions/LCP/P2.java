package org.example.solutions.LCP;

public class P2 {
    class Solution {
        public int[] fraction(int[] cont) {
            int n = cont.length;
            // a[1]+1/a[0]
            long c = 0, d = cont[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                long _c = (long) cont[i] * d + c;
                long _d = d;
                long g = gcd(_c, _d);
                _c /= g;
                _d /= g;
                // y = 1/x
                c = _d;
                d = _c;
            }
            // Final: y = x = 1/(1/x)
            return new int[]{(int) d, (int) c};
        }

        private static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}