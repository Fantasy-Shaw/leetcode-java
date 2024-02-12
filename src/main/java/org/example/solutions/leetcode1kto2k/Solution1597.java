package org.example.solutions.leetcode1kto2k;

import java.util.*;

import org.example.utils.Node;

public class Solution1597 {
    class Solution {
        public Node expTree(String s) {
            char[] postCs = infix2Postfix(s).toCharArray();
            Deque<Node> stack = new ArrayDeque<>();
            for (int i = 0; i < postCs.length; i++) {
                Node node = new Node(postCs[i]);
                if (!Character.isDigit(postCs[i])) {
                    node.right = stack.pop();
                    node.left = stack.pop();
                }
                stack.push(node);
            }
            Node root = stack.pop();
            return root;
        }

        private String infix2Postfix(String s) { // 中缀表达式转后缀表达式
            Deque<Character> stack = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    stack.push(ch);
                } else if (ch == '+' || ch == '-') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == '*' || ch == '/') {
                    while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-') {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
}