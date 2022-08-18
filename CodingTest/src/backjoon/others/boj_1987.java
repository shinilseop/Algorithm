package backjoon.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1987 {
    static int R, C;
    static boolean[] visited;
    static char[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        R = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        visited = new boolean[26];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        answer=0;

        cnt = 1;
        visited[map[0][0] - 'A'] = true;
        dfs(0,0);
        System.out.println(answer);
    }

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void dfs(int y, int x) {

        for (int dir = 0; dir < dx.length; dir++) {
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];

            if (0 <= nextY && nextY < map.length && 0 <= nextX && nextX < map[0].length){
                if (!visited[map[nextY][nextX] - 'A']) {
                    visited[map[nextY][nextX] - 'A'] = true;

                }
            }
        }
    }
}
