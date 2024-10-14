package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.List;

public class Solution997 {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            List<List<Integer>> trustList = new ArrayList<>();
            List<List<Integer>> beTrusted = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                trustList.add(new ArrayList<>());
                beTrusted.add(new ArrayList<>());
            }
            for (int[] t : trust) {
                trustList.get(t[0]).add(t[1]);
                beTrusted.get(t[1]).add(t[0]);
            }
            int judgeId = -1;
            for (int i = 1; i <= n; i++) {
                if (trustList.get(i).isEmpty() && beTrusted.get(i).size() == n - 1) {
                    if (judgeId == -1) judgeId = i;
                    else return -1; // not unique
                }
            }
            return judgeId;
        }
    }
}