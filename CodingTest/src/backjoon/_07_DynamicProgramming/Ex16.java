package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16 {
    static int[][] things;
    static int[][] dp;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        things = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (things[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things[i][0]] + things[i][1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

//        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                System.out.printf("%4d", dp[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        System.out.println(dp[n][k]);
    }
}
