package backjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649 {
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb;

    public static void dfs(String answer, int depth) {
        if (depth == M) {
            sb.append(answer).append('\n');
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(answer + ' ' + i, depth + 1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        sb = new StringBuilder();

//        dfs("",0);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(String.valueOf(i), 1);
                visited[i]=false;
            }
        }

        System.out.print(sb.toString().trim());
    }
}
