package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution348 {
    class TicTacToe {
        private int[][] board;
        private int n;

        public TicTacToe(int n) {
            this.n = n;
            board = new int[n][n];
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;
            if (check(1)) return 1;
            else if (check(2)) return 2;
            else return 0;
        }

        private boolean check(int player) {
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (; j < n; j++) {
                    if (board[i][j] != player) break;
                }
                if (j == n) return true;
            }
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (; j < n; j++) {
                    if (board[j][i] != player) break;
                }
                if (j == n) return true;
            }
            int i, j;
            for (i = 0, j = 0; i < n && j < n; i++, j++) {
                if (board[j][i] != player) break;
            }
            if (i == n) return true;
            for (i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
                if (board[j][i] != player) break;
            }
            return i == n;
        }
    }
}