package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] triangle = new int[size][];
        int[][] dp = new int[size][];
        for (int i = 0; i < size; i++) {
            triangle[i] = new int[i + 1];
            dp[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        if (size > 1) {
            dp[1][0] = triangle[0][0] + triangle[1][0];
            dp[1][1] = triangle[0][0] + triangle[1][1];
            for (int i = 2; i < size; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (j == 0)
                        dp[i][j] = triangle[i][j] + dp[i - 1][j];
                    else if (j == dp[i].length - 1)
                        dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                    else
                        dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp[size - 1].length; i++) {
            max = Math.max(max, dp[size - 1][i]);
        }

        System.out.println(max);
    }
}
