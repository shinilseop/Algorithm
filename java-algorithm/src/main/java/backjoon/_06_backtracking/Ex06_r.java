package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex06_r {
    static int[][] sudoku;
    static ArrayList<Point> blankIdx;

    public static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void dfsSudoku(int cnt) {
        if (blankIdx.size() == cnt) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 9; i++) {
                sb.append(sudoku[i][0]);
                for (int j = 1; j < 9; j++) {
                    sb.append(' ').append(sudoku[i][j]);
                }
                sb.append('\n');
            }

            System.out.print(sb.toString().strip());
            System.exit(0);
        }

        Point p = blankIdx.get(cnt);

        for (int i = 1; i <= 9; i++) {
            if (canBatch(p, i)) {
                sudoku[p.y][p.x] = i;
                dfsSudoku(cnt + 1);
            }
        }
    }

    public static boolean canBatch(Point p, int value) {
        // 가로 세로 검사
        for (int i = 0; i < 9; i++) {
            if (value == sudoku[p.y][i]) {
                return false;
            }

            if (value == sudoku[i][p.x]) {
                return false;
            }
        }

        // 3 x 3 검사
        int xRange = (p.x / 3) * 3;
        int yRange = (p.y / 3) * 3;
        for (int i = yRange; i < yRange + 3; i++) {
            for (int j = xRange; j < xRange + 3; j++) {
                if (value == sudoku[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        blankIdx = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    blankIdx.add(new Point(i, j));
                }
            }
        }

        dfsSudoku(0);
    }
}
