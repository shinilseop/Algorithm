package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex07 {
    static int[][][] map;
    static int height, width, depth;
    static int maxCnt, cnt, day;
    static int[] _x = {-1, 0, 0, 1, 0, 0}, _y = {0, -1, 0, 0, 1, 0}, _z = {0, 0, -1, 0, 0, 1};

    public static class Point {
        int z, y, x;

        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void bfs(Queue<Point> q) {
        Queue<Point> tmpQ = new LinkedList<>();
//        System.out.println("START");
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < _x.length; i++) {
                int tmpZ = p.z+_z[i];
                int tmpY = p.y+_y[i];
                int tmpX = p.x+_x[i];

                if (0 <= tmpZ && tmpZ < depth) {
                    if (0 <= tmpY && tmpY < height) {
                        if (0 <= tmpX && tmpX < width) {
                            if (map[tmpZ][tmpY][tmpX] == 0) {
                                map[tmpZ][tmpY][tmpX] = 1;
                                cnt++;
                                tmpQ.offer(new Point(tmpZ, tmpY, tmpX));
                            }
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
        depth = Integer.parseInt(st.nextToken());
        map = new int[depth][height][width];
        maxCnt = depth * height * width;
        cnt=day=0;
        Queue<Point> q = new LinkedList<>();

        for (int k = 0; k < depth; k++) {
            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < width; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        cnt++;
                        q.offer(new Point(k, i, j));
                    } else if (map[k][i][j] == -1) {
                        maxCnt--;
                    }
                }
            }
        }

        bfs(q);

//        for (int i = 0; i < depth; i++) {
//            System.out.println(i+" depth");
//            for (int j = 0; j < height;j++) {
//                System.out.println(Arrays.toString(map[i][j]));
//            }
//            System.out.println();
//        }

        if (maxCnt == cnt) {
            System.out.println(day-1);
        } else {
            System.out.println(-1);
        }
    }
}
