package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution353 {
    class SnakeGame {
        private int w, h, foodId, score;
        private int[][] food;
        private Deque<Integer> snake;
        private Set<Integer> seen;

        public SnakeGame(int width, int height, int[][] food) {
            w = width;
            h = height;
            this.food = food;
            foodId = 0;
            score = 0;
            snake = new ArrayDeque<>();
            seen = new HashSet<>();
            snake.addLast(0);
            seen.add(0);
        }

        public int move(String direction) {
            int head = snake.peekLast();
            int r = head / w, c = head % w;
            if (direction.equals("U")) {
                r--;
            } else if (direction.equals("L")) {
                c--;
            } else if (direction.equals("R")) {
                c++;
            } else {
                r++;
            }
            if (r < 0 || r >= h || c < 0 || c >= w) {
                return -1;
            }
            if (foodId < food.length && r == food[foodId][0] && c == food[foodId][1]) {
                seen.add(r * w + c);
                snake.addLast(r * w + c);
                foodId++;
                score++;
                return score;
            }
            // 去尾
            seen.remove(snake.pollFirst());
            // 撞自己
            if (seen.contains(r * w + c)) {
                return -1;
            } else {
                // 加头
                seen.add(r * w + c);
                snake.addLast(r * w + c);
                return score;
            }
        }
    }
}