package Test_Result;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class doubleArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[][] dp = new int[X + 1][3];

        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 0;

        System.out.println(dp[X]);

    }
}
