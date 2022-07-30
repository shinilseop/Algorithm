package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int cost[][] = new int[loop][3];
        for (int i = 0; i < cost.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int beforeIdx = -1;
        for (int i = 0; i < cost.length - 2; i++) {
            int min0 = Integer.MAX_VALUE;
            if (beforeIdx != 0) {
                min0 = Math.min(cost[i][0] + cost[i + 1][1] + cost[i + 2][0], cost[i][0] + cost[i + 1][1] + cost[i + 2][2]);
                min0 = Math.min(min0, Math.min(cost[i][0] + cost[i + 1][2] + cost[i + 2][0], cost[i][0] + cost[i + 1][2] + cost[i + 2][1]));
            }

            int min1 = Integer.MAX_VALUE;
            if (beforeIdx != 1) {
                min1 = Math.min(cost[i][1] + cost[i + 1][0] + cost[i + 2][1], cost[i][1] + cost[i + 1][0] + cost[i + 2][2]);
                min1 = Math.min(min1, Math.min(cost[i][1] + cost[i + 1][2] + cost[i + 2][0], cost[i][1] + cost[i + 1][2] + cost[i + 2][1]));
            }

            int min2 = Integer.MAX_VALUE;
            if (beforeIdx != 2) {
                min2 = Math.min(cost[i][2] + cost[i + 1][0] + cost[i + 2][1], cost[i][2] + cost[i + 1][0] + cost[i + 2][2]);
                min2 = Math.min(min2, Math.min(cost[i][2] + cost[i + 1][1] + cost[i + 2][0], cost[i][2] + cost[i + 1][1] + cost[i + 2][2]));
            }

//            System.out.println(min0+" "+min1+" "+min2);
            if (min0 <= min1) {
                if (min0 <= min2) {
                    sum += cost[i][0];
                    beforeIdx = 0;
                } else {
                    sum += cost[i][2];
                    beforeIdx = 2;
                }
            } else if (min1 <= min2) {
                sum += cost[i][1];
                beforeIdx = 1;
            } else {
                sum += cost[i][2];
                beforeIdx = 2;
            }
        }

        int min0 = Integer.MAX_VALUE;
        if (beforeIdx != 0) {
            min0 = Math.min(cost[loop-2][0] + cost[loop-1][1], cost[loop-2][0] + cost[loop-1][2]);
        }

        int min1 = Integer.MAX_VALUE;
        if (beforeIdx != 1) {
            min1 = Math.min(cost[loop-2][1] + cost[loop-1][0], cost[loop-2][1] + cost[loop-1][2]);
        }

        int min2 = Integer.MAX_VALUE;
        if (beforeIdx != 2) {
            min2 = Math.min(cost[loop-2][2] + cost[loop-1][0], cost[loop-2][2] + cost[loop-1][1]);
        }


//        System.out.println(min0+" "+min1+" "+min2);

        if (min0 <= min1) {
            if (min0 <= min2) {
                sum += min0;
            } else {
                sum += min2;
            }
        } else if (min1 <= min2) {
            sum += min1;
        } else {
            sum += min2;
        }

        System.out.println(sum);
    }
}
