package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex02 {
    static StringBuffer sb;
    static boolean visited[];
    static int n, m;

    public static void loopNumbers(String str, int start, int deep) {
        if (deep == 1) {
            if(str.length()>=(m*2+-1))
                sb.append(str).append("\n");
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                loopNumbers(str+" "+i, i+1,deep-1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sb = new StringBuffer(n * m * 3);
        visited = new boolean[n + 1];

        for (int i = 1; i < visited.length - m + 1; i++) {
            loopNumbers(i+"", i+1, m);
        }

        System.out.print(sb.toString());
    }
}
