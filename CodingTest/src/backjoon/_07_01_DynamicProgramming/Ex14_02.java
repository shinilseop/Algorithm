package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = (br.readLine()).toCharArray();
        char[] s2 = (br.readLine()).toCharArray();

        int[][] dp = new int[s2.length+1][s1.length+1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[j][i] = dp[j-1][i-1]+1;
                } else {
                    dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
                }
            }
        }

//        System.out.println();
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[i].length; j++) {
//                System.out.printf("%4d", dp[i][j]);
//            }
//            System.out.println();
//        }


        System.out.println(dp[s2.length][s1.length]);
    }
}
