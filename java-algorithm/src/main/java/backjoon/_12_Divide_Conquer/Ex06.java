package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    static int[][] input1, input2;
    static int row1, col1, row2, col2;

    public static int[][] matrixMultiple(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return new int[][]{{-1}};
        }

        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int t = 0; t < matrix1[0].length; t++) {
                    result[i][j]+=matrix1[i][t] * matrix2[t][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row1 = Integer.parseInt(st.nextToken());
        col1 = Integer.parseInt(st.nextToken());
        input1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col1; j++) {
                input1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        row2 = Integer.parseInt(st.nextToken());
        col2 = Integer.parseInt(st.nextToken());
        input2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col2; j++) {
                input2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] multiple = matrixMultiple(input1, input2);
        StringBuffer sb = new StringBuffer(multiple.length*(multiple[0].length*2+2));
        for (int i = 0; i < multiple.length; i++) {
            for (int j = 0; j < multiple[i].length; j++) {
                sb.append(multiple[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
