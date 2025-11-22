package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex06 {
    static int[][] map;
    static int height, width;
    static int maxCnt, cnt, day;
    static int[] _x = {-1, 0, 1, 0}, _y = {0, -1, 0, 1};

    public static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void bfs(Queue<Point> q) {
        Queue<Point> tmpQ = new LinkedList<>();
//        System.out.println("START");
        while (!q.isEmpty()) {
            Point p = q.poll();


            for (int i = 0; i < 4; i++) {
                int tmpY = p.y+_y[i];
                int tmpX = p.x+_x[i];

                if (0 <= tmpY && tmpY < height) {
                    if (0 <= tmpX && tmpX < width) {
                        if (map[tmpY][tmpX] == 0) {
                            map[tmpY][tmpX] = 1;
                            cnt++;
                            tmpQ.offer(new Point(tmpY, tmpX));
                        }
                    }
                }
            }

            if (q.isEmpty()) {
                day++;
                q = tmpQ;
                tmpQ = new LinkedList<>();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        maxCnt = height * width;
        cnt=day=0;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cnt++;
                    q.offer(new Point(i, j));
                } else if (map[i][j] == -1) {
                    maxCnt--;
                }
            }
        }

        bfs(q);

        if (maxCnt == cnt) {
            System.out.println(day-1);
        } else {
            System.out.println(-1);
        }
    }
}
