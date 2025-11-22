package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex09 {
    static final int BROKEN = 1, NOT_BROKEN = 0;

    static int[][] map;
    static boolean[][][] visited;
    static int height, width;
    static int[] _x = {-1, 0, 1, 0}, _y = {0, -1, 0, 1};

    public static class Point {
        int y, x, step, broken;

        public Point(int y, int x, int step, int broken) {
            this.y = y;
            this.x = x;
            this.step = step;
            this.broken = broken;
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1,NOT_BROKEN));
        visited[0][0][NOT_BROKEN] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == height - 1 && p.x == width - 1) {
                System.out.println(p.step);
                return;
            }

            for (int i = 0; i < _x.length; i++) {
                int tmpY = p.y + _y[i];
                int tmpX = p.x + _x[i];

                if (0 <= tmpY && tmpY < height) {
                    if (0 <= tmpX && tmpX < width) {
                        if (map[tmpY][tmpX] == 1) {
                            if (!visited[tmpY][tmpX][BROKEN] && p.broken == NOT_BROKEN) {
                                visited[tmpY][tmpX][BROKEN] = true;
                                q.offer(new Point(tmpY, tmpX, p.step + 1, BROKEN));
                            }
                        } else {
                            if (!visited[tmpY][tmpX][p.broken]) {
                                visited[tmpY][tmpX][p.broken] = true;
                                q.offer(new Point(tmpY, tmpX, p.step + 1, p.broken));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        visited = new boolean[height][width][2];

        for (int i = 0; i < height; i++) {
            char[] inputC = (br.readLine()).toCharArray();
            for (int j = 0; j < width; j++) {
                map[i][j] = inputC[j]-'0';
            }
        }

        bfs();
    }
}
