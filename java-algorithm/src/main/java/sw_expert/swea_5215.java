package sw_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class swea_5215 {
    static boolean[] visited;

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int map[][];
    static int answer;

    public static void dirDFS(int y, int x) {
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && nextY < map.length) {
                if (0 <= nextX && nextX < map[nextY].length) {
                    if (map[nextY][nextX] == 1) {
                        dirDFS(nextY, nextX);
                        answer++;
                    }
                }
            }
        }
    }

    public void dfs() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs();
                visited[i] = false;
            }
        }
    }

    public static void comb(int idx, int maxCnt, int cnt) {
        if (maxCnt == cnt) {
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        if (idx == visited.length) {
            return;
        }

        visited[idx] = true;
        comb(idx + 1, maxCnt, cnt+1);
        visited[idx] = false;
        comb(idx + 1, maxCnt, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            visited = new boolean[N];
            for (int i = 1; i <= N; i++) {
                System.out.println("==="+i+"===");
                comb(0, i, 0);
            }
//            int maxCal = Integer.parseInt(st.nextToken());
//
//            List<Food> foods = new ArrayList<>();
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                foods.add(new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//            }

        }
    }

    static class Food {
        int taste;
        int cal;

        public Food(int taste, int cal) {
            this.taste = taste;
            this.cal = cal;
        }
    }
}
