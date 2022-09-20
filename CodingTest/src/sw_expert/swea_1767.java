package sw_expert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//3
//7
//0 0 1 0 0 0 0
//0 0 1 0 0 0 0
//0 0 0 0 0 1 0
//0 0 0 0 0 0 0
//1 1 0 1 0 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 0 0
public class swea_1767 {
    static int N;
    static List<Point> core;
    static int minDist, maxCore;
    static int maxDepth;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void dfs(int[][] map, int dist, int coreCnt, int depth) {
        if (depth == maxDepth) {
            if (coreCnt > maxCore) {
                maxCore = coreCnt;
                minDist = dist;
            } else if (coreCnt == maxCore) {
                minDist = Math.min(minDist, dist);
            }
            return;
        }

        for (Point p : core) {
            if (!p.isElect) {
                p.isElect = true;
                for (int i = 0; i < 4; i++) {
                    int[][] temp = new int[N][N];
                    for (int j = 0; j < N; j++) {
                        temp[j] = map[j].clone();
                    }
                    int moved = connect(temp, p.y, p.x, i);
                    if (moved == -1) {
                        dfs(temp, dist, coreCnt, depth + 1);
                    } else {
                        dfs(temp, dist + moved, coreCnt + 1, depth + 1);
                    }
                }
                p.isElect = false;
            }
        }
    }

    public static int connect(int[][] map, int y, int x, int dir) {
        int dist = -1;

        int nowY = y;
        int nowX = x;
        int cnt = 0;
        while (true) {
            nowY += dy[dir];
            nowX += dx[dir];

            if (0 <= nowY && nowY < N && 0 <= nowX && nowX < N) {
                if (map[nowY][nowX] == 0) {
                    map[nowY][nowX] = 1;
                    cnt++;
                    continue;
                }
            } else {
                dist = cnt;
                break;
            }
            break;
        }

        return dist;
    }

    public static class Point {
        int y, x;
        boolean isElect;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
            if (y == 0 || x == 0 || y == N - 1 || x == N - 1) {
                isElect = true;
            } else {
                isElect = false;
                maxDepth++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            core = new ArrayList<>();
            minDist = Integer.MAX_VALUE;
            maxCore = 0;
            maxDepth = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        core.add(new Point(i, j));
                    }
                }
            }

            dfs(map, 0, 0, 0);

            System.out.println("#"+t+" "+minDist);
        }
    }
}
