package backjoon._06_backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex06_02 {
    static int sudoku[][];
    static int blank;
    static ArrayList<BlankPoint> blankPoints;

    public static void dfs(int idx) throws IOException {
        if (idx == blankPoints.size()) {
            StringBuffer sb = new StringBuffer(200);
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    sb.append(sudoku[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.print(sb.toString());
            System.exit(0);
        }

//        System.out.println(filled + "============================================");
//        System.out.println("x : " + x + ", y : " + y);
//        for (int i = 0; i < sudoku.length; i++) {
//            for (int j = 0; j < sudoku[i].length; j++) {
//                System.out.print(sudoku[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        BlankPoint point = blankPoints.get(idx);
        int x = point.x;
        int y = point.y;

        for (int num = 1; num <= 9; num++) {
            if (isPossible(num, x, y)) {
                sudoku[y][x] = num;
                dfs(idx+1);
                sudoku[y][x] = 0;
            }
        }
    }

    public static boolean isPossible(int num, int x, int y) {
        // 가로, 세로 체크
        for (int i = 0; i < sudoku.length; i++) {
            if (num == sudoku[y][i]) {
                return false;
            }

            if (num == sudoku[i][x]) {
                return false;
            }
        }

        int xRange = x / 3 * 3, yRange = y / 3 * 3;
        for (int i = yRange; i < yRange + 3; i++) {
            for (int j = xRange; j < xRange + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static class BlankPoint {
        int x, y;

        public BlankPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        blankPoints = new ArrayList<>();
        StringTokenizer st;
        sudoku = new int[9][9];
        blank = 0;

        for (int i = 0; i < sudoku.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    blankPoints.add(new BlankPoint(j, i));
                }
            }
        }

//        System.out.println("BLANK : "+blank);
        dfs(0);
    }
}
