package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution359 {
    class Logger {
        private Map<String, Integer> lastPrintTime;

        public Logger() {
            lastPrintTime = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            int last = lastPrintTime.getOrDefault(message, Integer.MIN_VALUE / 2);
            if (timestamp - last >= 10) {
                lastPrintTime.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}