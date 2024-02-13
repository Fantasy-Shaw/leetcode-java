package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution466 {
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 * len2 * n1 * n2 == 0) return 0;
            int idx = 0, cnt = 0;
            int[] idxRecord = new int[n1], cntRecord = new int[n1];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < len1; j++) {
                    if (s1.charAt(j) == s2.charAt(idx)) idx++;
                    if (idx == len2) {
                        idx = 0;
                        cnt++;
                    }
                }
                cntRecord[i] = cnt; // 记录遍历完i个s1后s2出现的次数
                idxRecord[i] = idx; // 记录遍历完第i个s1后s2下一个要被匹配到的字符下标
                // 查看该索引在之前是否已出现，出现即表示已经出现循环节，可以直接进行计算
                // 上一次出现该索引是在第j个s1中（同时可以说明第一个循环节的出现是从第j+1个s1开始的）
                for (int j = 0; j < i; j++) {
                    if (idxRecord[j] != idx) continue;
                    // 记录循环节出现之前的s2出现的个数
                    int preCnt = cntRecord[j];
                    // 记录所有循环节构成的字符串中出现s2的个数
                    int patternCnt = (n1 - j - 1) / (i - j) * (cntRecord[i] - cntRecord[j]);
                    // 记录剩余未构成完整循环节的部分出现的s2的个数
                    int remainCnt = cntRecord[j + (n1 - j - 1) % (i - j)] - cntRecord[j];
                    return (preCnt + patternCnt + remainCnt) / n2;
                }
            }
            return cntRecord[n1 - 1] / n2;
        }
    }
}