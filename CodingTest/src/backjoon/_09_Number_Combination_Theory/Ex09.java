package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex09 {
    public static long sigma(int loop, int num) {
        if (loop == 1) {
            return (num*(num+1))/2;
        }

        return (sigma(loop-1, num)*sigma(loop-1, num+1))/2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 20);

        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 1) {
                sb.append(m).append('\n');
            } else {
                sb.append(sigma(n - 1, m - n + 1)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
