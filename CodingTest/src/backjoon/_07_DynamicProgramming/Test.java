package backjoon._07_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    static int N;
    static int dp[];
    static int cb[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        cb=new int[N+1][2];
        int max = 0;

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cb[i][0] = Integer.parseInt(st.nextToken());
            cb[i][1] = Integer.parseInt(st.nextToken());
            dp[i]=1;
        }
        for(int i=1;i<=N;i++) {
            for(int j=i+1;j<=N;j++) {
                if(cb[i][0] > cb[j][0]) {
                    int tmp = cb[i][0];
                    cb[i][0] = cb[j][0];
                    cb[j][0] = tmp;
                    tmp = cb[i][1];
                    cb[i][1] = cb[j][1];
                    cb[j][1] = tmp;
                }
            }
        }

        if(N==1) {
            System.out.println(1);
        } else {
            for(int i=2;i<=N;i++) {
                for(int j=1;j<i;j++) {
                    if(cb[i][1] > cb[j][1] && dp[i] <= dp[j]) {
                        dp[i] = dp[j]+1;
                    }
                }
                max = Math.max(dp[i], max);
            }


            System.out.println();
            for (int i = 1; i <= N; i++) {
                System.out.print(dp[i]+" ");
            }
            System.out.println();
            System.out.println(N-max);
        }
    }
}
