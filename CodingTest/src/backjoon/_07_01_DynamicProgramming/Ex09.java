package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num == 1) {
            System.out.println(9);
        } else if (num == 2) {
            System.out.println(17);
        } else {
            int[][] dp = new int[num+1][10];
            dp[2][0] = 1;
            dp[2][1] = 1;
            dp[2][2] = 2;
            dp[2][3] = 2;
            dp[2][4] = 2;
            dp[2][5] = 2;
            dp[2][6] = 2;
            dp[2][7] = 2;
            dp[2][8] = 2;
            dp[2][9] = 1;

            for (int i = 3; i <= num; i++) {
                dp[i][0] = (dp[i-1][1])%1000000000;
                dp[i][1] = (dp[i-1][0]+dp[i-1][2])%1000000000;
                dp[i][2] = (dp[i-1][1]+dp[i-1][3])%1000000000;
                dp[i][3] = (dp[i-1][2]+dp[i-1][4])%1000000000;
                dp[i][4] = (dp[i-1][3]+dp[i-1][5])%1000000000;
                dp[i][5] = (dp[i-1][4]+dp[i-1][6])%1000000000;
                dp[i][6] = (dp[i-1][5]+dp[i-1][7])%1000000000;
                dp[i][7] = (dp[i-1][6]+dp[i-1][8])%1000000000;
                dp[i][8] = (dp[i-1][7]+dp[i-1][9])%1000000000;
                dp[i][9] = (dp[i-1][8])%1000000000;
            }

            int cnt = 0;
            for (int i = 0; i < dp[num].length; i++) {
                cnt = (cnt+dp[num][i])%1000000000;
            }

            System.out.println(cnt);
        }
    }
}
