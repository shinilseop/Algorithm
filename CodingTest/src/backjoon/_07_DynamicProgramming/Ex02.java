package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex02 {
    private static int w[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = new int[21][21][21];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                for (int k = 0; k < w[i][j].length; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) {
                        w[i][j][k] = 1;
                    } else if (i < j && j < k) {
//                        System.out.println(i + "," + j + "," + k + "=" + w[i][j][k - 1] + "+" + w[i][j - 1][k - 1] + "-" + w[i][j - 1][k]);
                        w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
                    } else {
//                        System.out.println(i + "," + j + "," + k + "=" + w[i - 1][j][k] + "+" + w[i - 1][j - 1][k] + "+" + w[i - 1][j][k - 1] + "-" + w[i - 1][j - 1][k - 1]);
                        w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
                    }
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            if (num1 == -1 && num2 == -1 && num3 == -1) {
                break;
            } else if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
                System.out.println("w(" + num1 + ", " + num2 + ", " + num3 + ") = " + 1);
            } else if (num1 > 20 || num2 > 20 || num3 > 20) {
                System.out.println("w(" + num1 + ", " + num2 + ", " + num3 + ") = " + w[20][20][20]);
            } else {
                System.out.println("w(" + num1 + ", " + num2 + ", " + num3 + ") = " + w[num1][num2][num3]);
            }
        }
    }
}
