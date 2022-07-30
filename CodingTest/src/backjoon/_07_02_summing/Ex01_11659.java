package backjoon._07_02_summing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end] - arr[start - 1]+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}
