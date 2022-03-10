package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01_r {
    static StringBuffer sb;
    static int N, M;
    static boolean[] visited;

    public static void dfs(String num) {
        if (num.length() / 2 + 1 == M) {
            sb.append(num).append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(num + " " + i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        sb = new StringBuffer();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(String.valueOf(i));
            visited[i] = false;
        }

        System.out.print(sb.toString().strip());
    }
}
