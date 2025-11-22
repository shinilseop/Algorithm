package backjoon._08_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int coinCnt = 0;
        for (int i = n - 1; i >= 0; i--) {
//            System.out.println(coin[i]+":"+k/coin[i]);
            if(k/coin[i] >= 1){
                coinCnt += k/coin[i];
                k %= coin[i];
            }
        }

        System.out.println(coinCnt);
    }
}
