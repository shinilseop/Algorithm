package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07 {
    static int[][] input;
    static int size;
    static long exponential;

    public static int[][] matrixMultiple(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int t = 0; t < size; t++) {
                    result[i][j]=(result[i][j]+(matrix1[i][t] * matrix2[t][j]))%1000;
                }
            }
        }
        return result;
    }

    public static int[][] exponentioalMatrix(long exp) {
        if (exp == 1) {
            return input;
        }

        int[][] result = exponentioalMatrix(exp/2);

        if (exp % 2 == 1) {
            return matrixMultiple(matrixMultiple(result, result), input);
        } else {
            return matrixMultiple(result, result);
        }
    }

    public static void printMatrix(int[][] matrix) {
        StringBuffer sb = new StringBuffer(matrix.length*(matrix[0].length*2+2));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        exponential = Long.parseLong(st.nextToken());
        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] multiple = exponentioalMatrix(exponential);
        printMatrix(multiple);
    }
}
