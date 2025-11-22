package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    static StringBuffer sb;
    static int n,m;

    public static void loopNumbers(String str, int start, int deep) {
        if (deep == 1) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            loopNumbers(str+" "+i, i, deep-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuffer(n * m * 3);

        for (int i = 1; i <= n; i++) {
            loopNumbers(i+"", i, m);
        }

        System.out.print(sb.toString());
    }
}
