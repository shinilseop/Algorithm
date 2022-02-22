package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16 {
    static int[][] things;
    static int[][][] dp; // 0=무게, 1=가치
    static int n, k;

    public static void compared(int i, int j) {
        // 0=무게, 1=가치
        // 가치가 높으면 높은쪽으로
        // 만약 같다면 무게가 적은쪽으로
        if (dp[i][i][0] + things[j][0] <= k) { // 집어 넣을 수 있다.
            if (dp[i][i][1] + things[j][1] >= dp[j - 1][i][1]) {
                if (dp[i][i][1] + things[j][1] == dp[j - 1][i][1]) {

                }
            }
        }


        if (dp[i][i][0] + things[j][0] <= k) {
            System.out.println((dp[j][i - 1][1] + things[j][1]) + ">" + dp[j - 1][i][1] + "?");
            if (dp[i][i][1] + things[j][1] >= dp[j - 1][i][1]) {
                if (dp[i][i][1] + things[j][1] >= dp[j][i - 1][1]) {
                    if (dp[i][i][1] + things[j][1] == dp[j][i - 1][1]) {

                    } else {
                        dp[j][i][0] = dp[j][i - 1][0] + things[j][0];
                        dp[j][i][1] = dp[j][i - 1][1] + things[j][1];
                    }
                } else if (dp[i][i][1] + things[j][1] < dp[j][i - 1][1]) {
                    dp[j][i][0] = dp[j][i - 1][0];
                    dp[j][i][1] = dp[j][i - 1][1];
                } else {
                    if (dp[i][i][0] + things[j][0] <= dp[j][i - 1][0]) {
                        dp[j][i][0] = dp[j][i - 1][0] + things[j][0];
                        dp[j][i][1] = dp[j][i - 1][1] + things[j][1];
                    } else {
                        dp[j][i][0] = dp[j][i - 1][0];
                        dp[j][i][1] = dp[j][i - 1][1];
                    }
                }
            } else if (dp[j - 1][i][1] > dp[j][i - 1][1]) {
                if ()
                    dp[j][i][0] = dp[j - 1][i][0];
                dp[j][i][1] = dp[j - 1][i][1];
            } else {
                dp[j][i][0] = dp[j][i - 1][0];
                dp[j][i][1] = dp[j][i - 1][1];
            }
        } else {
            if (dp[j][i - 1][1] > dp[j - 1][i][1]) {
                dp[j][i][0] = dp[j][i - 1][0];
                dp[j][i][1] = dp[j][i - 1][1];
            } else {
                dp[j][i][0] = dp[j - 1][i][0];
                dp[j][i][1] = dp[j - 1][i][1];
            }
        }
    }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        things = new int[n + 1][2];
        dp = new int[n + 1][n + 1][2]; // 0=무게, 1=가치

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
            dp[i][i][0] = things[i][0];
            dp[i][i][1] = things[i][1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                System.out.println("(" + j + "," + (i - 1) + "), j");
                System.out.println(dp[j][i - 1][0] + "+" + things[j][0] + "<=" + k + "?");

                // 0=무게, 1=가치
                if (dp[i][i][0] + things[j][0] <= k) {
                    System.out.println((dp[j][i - 1][1] + things[j][1]) + ">" + dp[j - 1][i][1] + "?");
                    if (dp[i][i][1] + things[j][1] >= dp[j - 1][i][1]) {
                        if (dp[i][i][1] + things[j][1] >= dp[j][i - 1][1]) {
                            if (dp[i][i][1] + things[j][1] == dp[j][i - 1][1]) {

                            } else {
                                dp[j][i][0] = dp[j][i - 1][0] + things[j][0];
                                dp[j][i][1] = dp[j][i - 1][1] + things[j][1];
                            }
                        } else if (dp[i][i][1] + things[j][1] < dp[j][i - 1][1]) {
                            dp[j][i][0] = dp[j][i - 1][0];
                            dp[j][i][1] = dp[j][i - 1][1];
                        } else {
                            if (dp[i][i][0] + things[j][0] <= dp[j][i - 1][0]) {
                                dp[j][i][0] = dp[j][i - 1][0] + things[j][0];
                                dp[j][i][1] = dp[j][i - 1][1] + things[j][1];
                            } else {
                                dp[j][i][0] = dp[j][i - 1][0];
                                dp[j][i][1] = dp[j][i - 1][1];
                            }
                        }
                    } else if (dp[j - 1][i][1] > dp[j][i - 1][1]) {
                        if ()
                            dp[j][i][0] = dp[j - 1][i][0];
                        dp[j][i][1] = dp[j - 1][i][1];
                    } else {
                        dp[j][i][0] = dp[j][i - 1][0];
                        dp[j][i][1] = dp[j][i - 1][1];
                    }
                } else {
                    if (dp[j][i - 1][1] > dp[j - 1][i][1]) {
                        dp[j][i][0] = dp[j][i - 1][0];
                        dp[j][i][1] = dp[j][i - 1][1];
                    } else {
                        dp[j][i][0] = dp[j - 1][i][0];
                        dp[j][i][1] = dp[j - 1][i][1];
                    }
                }
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", dp[i][j][1]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(dp[n][n][1] + " " + dp[n][n][0]);
    }
}
