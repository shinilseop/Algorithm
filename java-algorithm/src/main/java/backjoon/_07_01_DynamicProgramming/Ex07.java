package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] cost = new int[size];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[size][3];
        dp[0][1] = cost[0];
        dp[0][2] = 0;
        if (size > 1) {
            dp[1][1] = cost[0] + cost[1];
            dp[1][2] = cost[1];
            for (int i = 2; i < size; i++) {
//                    System.out.println(dp[i - 1][1] + " " + cost[i - 1] + "," + dp[i - 2][1]);
//                    if (dp[i - 1][1] == cost[i - 1] + cost[i - 2] + dp[i - 3][1]) {
//                        dp[i][1] = cost[i] + dp[i - 1][2];
//                        dp[i][2] = cost[i] + Math.max(dp[i - 2][1], dp[i - 2][2]);
//                    } else if (dp[i - 1][1] == cost[i - 1] + dp[i - 2][2]) {
//                        dp[i][1] = cost[i] + dp[i - 1][2];
//                        dp[i][2] = cost[i] + Math.max(dp[i - 2][1], dp[i - 2][2]);
//                    } else {
//                        dp[i][1] = cost[i] + Math.max(dp[i - 1][1], dp[i - 1][2]);
//                        dp[i][2] = cost[i] + Math.max(dp[i - 2][1], dp[i - 2][2]);
//                    }
                dp[i][1] = cost[i] + dp[i-1][2];
                dp[i][2] = cost[i] + Math.max(dp[i - 2][1], dp[i - 2][2]);
            }
        }

//        for (int i = 0; i < size; i++) {
//            System.out.println("COST:" + cost[i] + ", dp:" + dp[i][1] + ", " + dp[i][2]);
//        }

        System.out.println(Math.max(dp[size - 1][1], dp[size - 1][2]));
    }
}
