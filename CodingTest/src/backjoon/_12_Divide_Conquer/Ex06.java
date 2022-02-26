package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    static int[][] input1, input2;
    static int row, col;

    public static int[][] matrixMultiple(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2[0].length) {
            return new int[][]{{-1}};
        }

        int[][] result = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int t = 0; t < matrix1.length; t++) {
                    result[j][i]+=matrix1[t][i] + matrix2[j][t];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        input1 = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(st.nextToken());
            for (int j = 0; j < col; j++) {
                input1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        input2 = new int[col][row];
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(st.nextToken());
            for (int j = 0; j < row; j++) {
                input2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] multiple = matrixMultiple(input1, input2);

        for (int i = 0; i < multiple.length; i++) {
            for (int j = 0; j < multiple[i].length; j++) {
                System.out.print(multiple[i][j] + " ");
            }
            System.out.println();
        }
    }
}
