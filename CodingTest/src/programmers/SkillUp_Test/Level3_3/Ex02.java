package programmers.SkillUp_Test.Level3_3;

import java.util.Arrays;

public class Ex02 {
    public int solution(int[][] board, int[][] skills) {
        int[][] prefix = new int[board.length][board[0].length + 1];
        for (int[] skill : skills) {
            boolean isAttack = skill[0] == 1;
            int degree = isAttack ? -skill[5] : skill[5];

            prefix[skill[1]][skill[2]] += degree;
            prefix[skill[1]][skill[4]+1] += -degree;
            prefix[skill[3]+1][skill[2]] += -degree;
            prefix[skill[3]+1][skill[4]+1] += degree;
        }


        for (int i = 1; i < prefix[0].length; i++) {
            for (int j = 0; j < prefix.length; j++) {
                prefix[j][i] += prefix[j][i-1];
            }
        }

        for (int i = 1; i < prefix.length; i++) {
            for (int j = 0; j < prefix[i].length; j++) {
                prefix[i][j] += prefix[i-1][j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + prefix[i][j] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        Ex02 main = new Ex02();
        System.out.println(main.solution(board, skill));
    }
}
