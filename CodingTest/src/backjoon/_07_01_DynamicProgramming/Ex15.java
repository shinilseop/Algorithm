package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int arr[] = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[size];
        int max = dp[0] = arr[0];
        for (int i = 1; i < size; i++) {
            if(dp[i-1] < 0){
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i-1]+arr[i];
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
