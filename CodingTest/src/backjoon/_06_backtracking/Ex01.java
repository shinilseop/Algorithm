package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    static boolean[] visited;
    static StringBuilder sb;

    public static void makeNumbers(String str, int deep) {
        if(deep==1) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                makeNumbers(str+" "+i, deep - 1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sb = new StringBuilder(n*m*4);
        visited = new boolean[n+1];
        for(int i=1;i<visited.length;i++){
            if (!visited[i]) {
                visited[i]=true;
                makeNumbers(i+"", m);
                visited[i]=false;
            }
        }

        System.out.print(sb.toString());
    }
}
