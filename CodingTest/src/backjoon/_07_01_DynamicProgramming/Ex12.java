package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size + 1];
        int[] dp = new int[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = arr[1];
        int idx = 1;
        int maxIdx = 1;
        for (int i = 1; i <= size; i++) {
            if (dp[idx] > arr[i]) {
                dp[++idx] = arr[i];
            } else if (dp[idx] == arr[i]) {
                continue;
            }

            for (int j = idx - 1; j >= maxIdx; j--) {
                if (dp[j] > arr[i]) {
                    dp[j + 1] = arr[i];
                    break;
                }
            }

            boolean isChanged = false;
            for (int j = maxIdx; j > 0; j--) {
                if (dp[j] < arr[i]) {
                    dp[j + 1] = arr[i];
                    isChanged = true;

                    if (j == maxIdx)
                        maxIdx = j + 1;
                    if (j == idx)
                        idx += 1;
                    break;
                }
            }
            if (!isChanged) {
                dp[1] = arr[i];
            }

//            System.out.print(i + "(" + idx + "," + maxIdx + ")==> ");
//            for (int k = 1; k <= idx; k++) {
//                System.out.print(dp[k] + " ");
//            }
//            System.out.println();
        }

        System.out.println(idx);
    }
}
