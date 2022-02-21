package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num == 1) {
            System.out.println(0);
        } else if (num == 2 || num == 3) {
            System.out.println(1);
        } else {
            int[] dp = new int[num + 1];
            dp[2] = 1;
            dp[3] = 1;
//            System.out.println(2+" : "+1);
//            System.out.println(3+" : "+1);
            for (int i = 4; i <= num; i++) {
                int min = Integer.MAX_VALUE;
                if (i % 3 == 0) {
                    min = Math.min(min, 1 + dp[i / 3]);
                }

                if (i % 2 == 0) {
                    min = Math.min(min, 1 + dp[i / 2]);
                }

                min = Math.min(min, 1 + dp[i - 1]);

                dp[i] = min;

//                System.out.println(i+" : "+dp[i]);
            }

            System.out.println(dp[num]);
        }
    }
}
