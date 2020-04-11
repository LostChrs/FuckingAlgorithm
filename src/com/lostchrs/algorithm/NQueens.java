package com.lostchrs.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后问题
 * 给你一个 N×N 的棋盘，让你放置 N 个皇后，使得它们不能互相攻击
 * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位
 */
public class NQueens {
    public void run() {

        solve(6);
    }

    private void solve(int n) {

        //初始化棋盘 NxN
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowData.add("*");
            }
            board.add(rowData);
        }

        backtrack(board, 0);
    }

    private void backtrack(List<List<String>> board, int row) {
        if (board.size() <= row) {
            //成功了,输出棋盘
            System.out.println("=============");
            board.forEach(rowData -> {
                System.out.println(rowData.toString());
            });
            return;
        }

        List<String> rowData = board.get(row);
        for (int i = 0; i < rowData.size(); i++) {
            if (isValid(board, row, i)) {
                rowData.set(i, "Q");
                backtrack(board, row + 1);
                rowData.set(i, "*");
            }
        }
    }

    private boolean isValid(List<List<String>> board, int row, int col) {
        //同一列
        for (int i = 0; i < row; i++) {
            if (board.get(i).get(col) == "Q") {
                return false;
            }
        }
        //左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j) == "Q") {
                return false;
            }
        }
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).get(j) == "Q") {
                return false;
            }
        }
        return true;
    }
}
