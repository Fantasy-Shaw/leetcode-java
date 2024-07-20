package org.example.solutions.LCP;

import java.util.*;

public class P40 {
    class Solution {
        private static final int inf = 0x3f3f3f3f;

        public int maxmiumScore(int[] cards, int cnt) {
            Arrays.sort(cards);
            int n = cards.length, odd = 0;
            int ans = 0;
            int mnOdd = inf, mnEven = inf;
            for (int i = n - 1; i >= n - cnt; i--) {
                odd += cards[i] & 1;
                ans += cards[i];
                if ((cards[i] & 1) == 1) {
                    mnOdd = Math.min(mnOdd, cards[i]);
                } else {
                    mnEven = Math.min(mnEven, cards[i]);
                }
            }
            if ((odd & 1) == 0) {
                return ans;
            }
            int ans1 = ans - mnOdd;
            boolean hasEven = false;
            for (int i = n - cnt - 1; i >= 0; i--) {
                if ((cards[i] & 1) == 0) {
                    hasEven = true;
                    ans1 += cards[i];
                    break;
                }
            }
            ans1 = hasEven ? ans1 : -1;
            int ans2 = -1;
            if (mnEven < inf) {
                ans2 = ans - mnEven;
                boolean hasOdd = false;
                for (int i = n - cnt - 1; i >= 0; i--) {
                    if ((cards[i] & 1) == 1) {
                        hasOdd = true;
                        ans2 += cards[i];
                        break;
                    }
                }
                ans2 = hasOdd ? ans2 : -1;
            }
            if (ans1 == -1 && ans2 == -1) {
                return 0;
            }
            return Math.max(ans1, ans2);
        }
    }
}