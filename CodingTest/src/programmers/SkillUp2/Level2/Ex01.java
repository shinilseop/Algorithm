package programmers.SkillUp2.Level2;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01 {
    public boolean isSquare(int[][] board, int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] == 0) {
                    System.out.println(i + ", " + j + " is 0");
                    return false;
                }
            }
        }

        return true;
    }

    public int solution(int[][] board) {
//        int maxSize = Math.min(board.length, board[0].length);

//        for (int size = maxSize; size > 0; size--) {
//            for (int y = 0; y <= board.length - size; y++) {
//                for (int x = 0; x <= board[y].length - size; x++) {
//                    System.out.println(size+":"+y+", "+x+" START");
//                    if (isSquare(board, y, x, size)) {
//                        return size*size;
//                    }
//                }
//            }
//        }

        int[][] prefix = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    prefix[i][j] = j > 0 ? prefix[i][j - 1] + board[i][j] : board[i][j];
                }
            }
        }

//        for (int i = 0; i < prefix.length; i++) {
//            System.out.println(Arrays.toString(prefix[i]));
//        }

        int maxSize = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = 0; j < prefix[0].length; j++) {
                if (prefix[i][j] != 0) {
                    int size = prefix[i][j];
                    int len = i+prefix[i][j];
                    if (len > prefix.length) {
                        size = size - (len-prefix.length);
                        len = len - (len-prefix.length);
                    }
                    for (int k = i + 1; k < len; k++) {
                        size = Math.min(size, prefix[k][j]);
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize * maxSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Ex01 main = new Ex01();
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = {{0, 1, 0, 1, 1}, {1, 1, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 1, 0}};
        System.out.println(main.solution(board2));
    }
}
