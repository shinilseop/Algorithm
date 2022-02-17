package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex06 {
    static int[][] sudoku;
    static int blank;

    public static boolean dfs(int filled) {
        if (blank == filled) {
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }

            return true;
        }

//        System.out.println("========"+filled+"========");
//        for (int i = 0; i < sudoku.length; i++) {
//            for (int j = 0; j < sudoku[i].length; j++) {
//                System.out.print(sudoku[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j] == 0) {
                    ArrayList<Integer> possible = possibleNumbers(i,j);
                    if(possible.size()==0)
                        return false;

//                    System.out.println("POSSIBLE : "+ possible.toString());
                    for (Integer num : possible) {
                        sudoku[i][j] = num;
                        if(dfs(filled+1)){
                            return true;
                        }
                    }
                    sudoku[i][j] = 0;
                }
            }
        }

        return false;
    }

    public static ArrayList<Integer> possibleNumbers(int y, int x) {
        ArrayList<Integer> numbers = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }};
        int x_range = 3;
        int y_range = 3;

        while (x_range <= x || y_range <= y) {
            if (x_range <= x)
                x_range += 3;
            if (y_range <= y)
                y_range += 3;
        }

//        System.out.println("check "+x+" "+y);
//        System.out.println("range x:"+(x_range-3)+"~"+x_range+", y:"+(y_range-3)+"~"+y_range);
        // 칸 체크
        for (int i = y_range - 3; i < y_range; i++) {
            for (int j = x_range - 3; j < x_range; j++) {
                if (sudoku[i][j] != 0) {
//                    System.out.println("REMOVE : "+sudoku[i][j]+"["+j+","+i+"]");
                    int removeIdx =  numbers.indexOf(sudoku[i][j]);
                    if(removeIdx != -1)
                        numbers.remove(removeIdx);
                }
            }
        }

        // 가로 체크
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[y][i] != 0) {
//                System.out.println("REMOVE : "+sudoku[y][i]+"["+i+","+y+"]");
                int removeIdx =  numbers.indexOf(sudoku[y][i]);
                if(removeIdx != -1)
                    numbers.remove(removeIdx);
            }
        }

        // 세로 체크
        for (int i = 0; i < sudoku[x].length; i++) {
            if (sudoku[i][x] != 0) {
//                System.out.println("REMOVE : "+sudoku[i][x]+"["+x+","+i+"]");
                int removeIdx =  numbers.indexOf(sudoku[i][x]);
                if(removeIdx != -1)
                    numbers.remove(removeIdx);
            }
        }

        return numbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sudoku = new int[9][9];
        blank = 0;

        for (int i = 0; i < sudoku.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    blank++;
                }
            }
        }

//        System.out.println("BLANK : "+blank);
        dfs(0);
    }
}
