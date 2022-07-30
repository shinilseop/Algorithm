package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] drink = new int[size+1];
        for (int i = 1; i <= size; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        if (size == 1) {
            System.out.println(drink[1]);
        } else {
            int[][] dp = new int[size + 1][3];
            dp[1][0] = 0;
            dp[1][1] = drink[1];
            dp[1][2] = drink[1];
            for (int i = 2; i <= size; i++) {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
                dp[i][1] = dp[i-1][0]+drink[i];
                dp[i][2] = dp[i-1][1]+drink[i];
            }

//            for (int i = 1; i <= size; i++) {
//                System.out.println(i+",0:"+dp[i][0]);
//                System.out.println(i+",1:"+dp[i][1]);
//                System.out.println(i+",2:"+dp[i][2]);
//            }

            System.out.println(Math.max(dp[size][0], Math.max(dp[size][1], dp[size][2])));
        }
    }
}
