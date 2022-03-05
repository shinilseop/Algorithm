package programmers.SkillUp_Test.Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01 {
    static final int MOD = 1000000007;
    static int[][] dist;
    static boolean[][] isPuddle, visited;
    static int M, N;
    static int cnt;

    public static void dfs(int y, int x) {
        if (y < N && !isPuddle[y + 1][x]) {
            if (!visited[y + 1][x]) {
                visited[y + 1][x] = true;
                dist[y + 1][x] = 1;
                dfs(y + 1, x);
            } else {
                dist[y][x] += dist[y + 1][x];
                cnt = (cnt + dist[y + 1][x]) % MOD;
            }
        }

        if (x < M && !isPuddle[y][x + 1]) {
            if (!visited[y][x + 1]) {
                visited[y][x + 1] = true;
                dist[y][x + 1] = 1;
                dfs(y, x + 1);
            } else {
                dist[y][x] += dist[y][x + 1];
                cnt = (cnt + dist[y][x + 1]) % MOD;
            }
        }
    }

    public static int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        cnt = 0;
        dist = new int[N + 1][M + 1];
        isPuddle = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < puddles.length; i++) {
            isPuddle[puddles[i][1]][puddles[i][0]] = true;
        }

        dfs(1,1);

        return cnt;
    }

    public static void main(String[] args) {
//        int m = 5;
//        int n = 5;
//        int[][] puddles = {{2, 2}, {3, 4}, {5, 4}};
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(solution(m, n, puddles));
    }
}
