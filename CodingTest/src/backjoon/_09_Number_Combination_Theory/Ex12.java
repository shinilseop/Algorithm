package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex12 {
    public static int cntDiv(int num, int div) {
        int count = 0;
        while (num >= div) {
            count += num / div;
            num /= div;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt2 = cntDiv(n, 2) - cntDiv(m, 2) - cntDiv(n - m, 2);
        int cnt5 = cntDiv(n, 5) - cntDiv(m, 5) - cntDiv(n - m, 5);

        int min = Math.min(cnt2, cnt5);

        System.out.println(min > 0 ? min : 0);
    }
}
