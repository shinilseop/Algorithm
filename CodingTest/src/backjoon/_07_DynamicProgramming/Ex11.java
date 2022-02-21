package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] numbers = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int idx=0;
        int[] dp = new int[size];// 0 = max value, 1 = cnt
        dp[0] = numbers[0];
        for (int i = 1; i < size; i++) {
            if(dp[idx] == numbers[i]){
                continue;
            } else if (dp[idx] < numbers[i]) {
                dp[++idx] = numbers[i];
            } else {
                boolean isChanged = false;
                for (int j = idx - 1; j >= 0; j--) {
                    if (dp[j] < numbers[i]) {
                        dp[j+1] = numbers[i];
                        isChanged=true;
                        break;
                    }
                }
                if (!isChanged) {
                    dp[0] = numbers[i];
                }
            }


//            System.out.print(i+"==> ");
//            for(int k=0;k<dp.length;k++)
//                System.out.print(k+":"+dp[k]+"  ");
//            System.out.println();

        }


        System.out.println(idx+1);
    }
}
