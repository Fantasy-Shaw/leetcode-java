package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution227and772 {
    class Solution {
        private final Map<Character, Integer> map = new HashMap<>() {{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }};

        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            char[] cs = s.toCharArray();
            int n = s.length();
            Deque<Integer> numStack = new LinkedList<>();
            Deque<Character> opStack = new LinkedList<>();
            numStack.push(0);
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == '(') {
                    opStack.push(c);
                } else if (c == ')') {
                    while (!opStack.isEmpty()) {
                        if (opStack.peek() != '(') {
                            calc(numStack, opStack);
                        } else { // ')'
                            opStack.pop();
                            break;
                        }
                    }
                } else {
                    if (Character.isDigit(c)) {
                        int u = 0, j = i;
                        while (j < n && Character.isDigit(cs[j])) {
                            u = u * 10 + cs[j++] - '0';
                        }
                        numStack.push(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                            numStack.push(0);
                        }
                        while (!opStack.isEmpty() && opStack.peek() != '(') {
                            char prevOp = opStack.peek();
                            if (map.get(prevOp) >= map.get(c)) {
                                calc(numStack, opStack);
                            } else {
                                break;
                            }
                        }
                        opStack.push(c);
                    }
                }
            }
            while (!opStack.isEmpty()) {
                calc(numStack, opStack);
            }
            return numStack.peek();
        }

        private void calc(Deque<Integer> numStack, Deque<Character> opStack) {
            if (numStack.isEmpty() || numStack.size() < 2) return;
            if (opStack.isEmpty()) return;
            int b = numStack.pop(), a = numStack.pop();
            char op = opStack.pop();
            switch (op) {
                case '+':
                    numStack.push(a + b);
                    break;
                case '-':
                    numStack.push(a - b);
                    break;
                case '*':
                    numStack.push(a * b);
                    break;
                case '/':
                    numStack.push(a / b);
                    break;
                case '^':
                    numStack.push((int) Math.pow(a, b));
                    break;
                case '%':
                    numStack.push(a % b);
                    break;
                default:
                    break;
            }
        }
    }
}