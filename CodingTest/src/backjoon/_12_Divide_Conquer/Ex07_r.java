package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07_r {
    static final int MOD = 1000;
    static int N;
    static long[][] matrix;

    public static long[][] multipleMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[N][N];

        for (int i = 0; i < N; i++) { // matrix1 행
            for (int j = 0; j < N; j++) { // matrix2 열
                for (int k = 0; k < N; k++) { // 각 행렬 순환용도
                    result[i][j] = (result[i][j] + (matrix1[i][k] * matrix2[k][j]) % MOD) % MOD;
                }
            }
        }

        return result;
    }

    public static long[][] exponential(long exp) {
        if (exp == 1) {
            return matrix;
        }

        long[][] tmp = exponential(exp / 2);
        if (exp % 2 == 0) {
            return multipleMatrix(tmp, tmp);
        } else {
            return multipleMatrix(multipleMatrix(tmp, tmp), matrix);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matrix = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken())%MOD;
            }
        }


        long[][] result = exponential(B);
//        long[][] result = multipleMatrix(matrix, matrix);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
