package programmers.SkillUp2.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01_2 {
    public boolean isSquere(int[][] board, int y, int x, int size) {
        for (int i = y - size + 1; i <= y; i++) {
            for (int j = x - size + 1; j <= x; j++) {
//                if (i < 0 || board.length <= i || j < 0 || board[i].length <= j) {
//                    return false;
//                }
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int solution(int[][] board) {
        int[][] prefix = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    prefix[i][j] = j > 0 ? prefix[i][j - 1] + board[i][j] : board[i][j];
                }
            }
        }

        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int size = prefix[i][j];
                if (size > 1) {
                    if (i - size < 0 || j - size < 0) {
                        size += Math.min(i-size, j-size);
                    }

                    if (isSquere(board, i, j, size)) {
                        dp[i][j] = (size + 1) * (size + 1);
                    }
                } else if (size == 1) {
                    dp[i][j] = 1;
                }

                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }


//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(prefix[i]));
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[board.length - 1][board[0].length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ex01_2 main = new Ex01_2();
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = {{0, 1, 0, 1, 1}, {1, 1, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 1, 0}};
        int[][] board3= {{0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(main.solution(board2));
    }
}
