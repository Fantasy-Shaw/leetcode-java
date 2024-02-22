package org.example.templates;
/*
  https://www.zhihu.com/question/21923021/answer/37475572
 */

import java.util.*;

public
class KMP {
    // 构造模式串 pattern 的最大匹配数表
    public static int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }

    // 在文本 text 中寻找模式串 pattern，返回所有匹配的位置开头
    public static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            if (count == pattern.length()) {
                positions.add(i - pattern.length() + 1);
                count = maxMatchLengths[count - 1];
            }
        }
        return positions;
    }

    // 构造模式串 pattern 的最大匹配数表
    public static int[] calculateMaxMatchLengths(int[] pattern) {
        int[] maxMatchLengths = new int[pattern.length];
        int maxLength = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (maxLength > 0 && pattern[maxLength] != pattern[i]) {
                maxLength = maxMatchLengths[maxLength - 1]; // ①
            }
            if (pattern[maxLength] == pattern[i]) {
                maxLength++; // ②
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }

    // 在数组 arr 中寻找模式串 pattern，返回所有匹配的位置开头
    public static List<Integer> search(int[] arr, int[] pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (count > 0 && pattern[count] != arr[i]) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern[count] == arr[i]) {
                count++;
            }
            if (count == pattern.length) {
                positions.add(i - pattern.length + 1);
                count = maxMatchLengths[count - 1];
            }
        }
        return positions;
    }
}
