package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08 {
    static final long MOD = 1000000007;
    static final long[][] A = {{1, 1}, {1, 0}};

    public static long[][] matrixMultiple(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int t = 0; t < matrix1[0].length; t++) {
                    result[i][j]=(result[i][j]+(matrix1[i][t] * matrix2[t][j]))%MOD;
                }
            }
        }
        return result;
    }

    public static long[][] exponentioalMatrix(long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }

        long[][] result = exponentioalMatrix(exp/2);

        if (exp % 2 == 1) {
            return matrixMultiple(matrixMultiple(result, result), A);
        } else {
            return matrixMultiple(result, result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long[][] A_exp = exponentioalMatrix(num-1);
        long[][] result = matrixMultiple(A_exp, new long[][]{{1}, {0}});
        System.out.println(result[0][0]%MOD);
    }
}
