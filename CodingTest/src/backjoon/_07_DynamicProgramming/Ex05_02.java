package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int home = Integer.parseInt(br.readLine());

        int[][] cost = new int[home][3];
        for (int i = 0; i < home; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[home][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        dp[1][0] = Math.min(cost[0][1], cost[0][2])+cost[1][0];
        dp[1][1] = Math.min(cost[0][0], cost[0][2])+cost[1][1];
        dp[1][2] = Math.min(cost[0][0], cost[0][1])+cost[1][2];

        for (int i = 2; i < home; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
//        }

        System.out.println(Math.min(dp[home-1][0], Math.min(dp[home-1][1], dp[home-1][2])));
    }
}
