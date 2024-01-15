package org.example.solutions.leetcode3k;

import org.example.templates.StringHash;

import java.util.*;

public class Solution3006And3008 {
    class Solution {
        StringHash hashS;
        long hashA, hashB;

        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            int ns = s.length(), na = a.length(), nb = b.length();
            hashS = new StringHash(s);
            hashA = new StringHash(a).getSubStrHash(0, na);
            hashB = new StringHash(b).getSubStrHash(0, nb);
            List<Integer> idxI = new ArrayList<>(), idxJ = new ArrayList<>();
            for (int i = 0, n = ns - na; i <= n; i++) {
                if (hashS.getSubStrHash(i, i + na) == hashA) idxI.add(i);
            }
            for (int j = 0, n = ns - nb; j <= n; j++) {
                if (hashS.getSubStrHash(j, j + nb) == hashB) idxJ.add(j);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i : idxI) {
                if (idxJ.isEmpty()) break;
                if (i <= idxJ.getFirst()) {
                    if (Math.abs(idxJ.getFirst() - i) <= k) {
                        ans.add(i);
                    }
                    continue;
                }
                if (i >= idxJ.getLast()) {
                    if (Math.abs(idxJ.getLast() - i) <= k) {
                        ans.add(i);
                    }
                    continue;
                }
                int l = -1, r = idxJ.size();//开区间
                while (l + 1 < r) {//区间不为空
                    int mid = l + (r - l) / 2;
                    if (idxJ.get(mid) < i) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                if (Math.abs(idxJ.get(r) - i) <= k) {
                    ans.add(i);
                    continue;
                }
                if (Math.abs(idxJ.get(l) - i) <= k) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}