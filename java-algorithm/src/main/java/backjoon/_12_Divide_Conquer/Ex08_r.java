package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08_r {
    static final int MOD = 1000000007;
    static long[][] A = {{1, 1}, {1, 0}};
    static final int SIZE = 2;

    public static long[][] matrixMultiple(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    result[i][j] = (result[i][j] + (matrix1[i][k] * matrix2[k][j])) % MOD;
                }
            }
        }

        return result;
    }

    public static long[][] exponential(long exp) {
        if (exp == 1) {
            return A;
        }

        long[][] tmp = exponential(exp / 2);

        if (exp % 2 == 0) {
            return matrixMultiple(tmp, tmp);
        } else {
            return matrixMultiple(matrixMultiple(tmp, tmp), A);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n == 0) {
            System.out.println(0);
        } else {
            long[][] result = exponential(n);

            System.out.println((result[1][0])%MOD);
        }
    }
}
