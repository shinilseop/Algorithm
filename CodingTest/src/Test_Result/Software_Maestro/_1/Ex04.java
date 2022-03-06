package Test_Result.Software_Maestro._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    // 가능한 조합의 칼로리 음식

    static int min = 2000, max = 2500;
    static boolean[] visited;

    public static int dfs(int[] cal, int start, int deep, int sum) {
        if (deep == 4) {
            if (min <= sum && sum <= max) {
                return 1;
            }
            return 0;
        }

        int cnt = 0;

        for (int i = start; i < cal.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                cnt+=dfs(cal, i + 1, deep+1, sum+cal[i]);
                visited[i]=false;
            }
        }

        return cnt;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int cal[] = new int[size];
        visited= new boolean[size];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dfs(cal, 0, 1, 0));
    }
}
