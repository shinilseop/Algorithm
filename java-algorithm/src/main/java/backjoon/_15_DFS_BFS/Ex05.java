package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex05 {
    static int[][] map;
    static int[][] visited;
    static int height, width;
    static int[] _x = {-1, 0, 1, 0}, _y = {0, -1, 0, 1};
    static int answer;

    public static void searchDFS(int y, int x, int step) {
        if (y == height - 1 && x == width - 1) {
            answer = Math.min(answer, step);
        }

        for (int i = 0; i < 4; i++) {
            int tmpX = x + _x[i];
            int tmpY = y + _y[i];

            if (0 <= tmpY && tmpY < height) {
                if (0 <= tmpX && tmpX < width) {
                    if (map[tmpY][tmpX] == 1 && visited[tmpY][tmpX] > step + 1) {
                        visited[tmpY][tmpX] = step + 1;
                        searchDFS(tmpY, tmpX, step + 1);
                    }
                }
            }
        }
    }

    public static class Point {
        int y, x, step;

        public Point(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

    public static void searchBFS(int y, int x, int step) {
        step = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x, step));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == width - 1 && p.y == height - 1) {
                System.out.println(p.step);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = p.x+_x[i];
                int tmpY = p.y+_y[i];

                if (0 <= tmpY && tmpY < height) {
                    if (0 <= tmpX && tmpX < width) {
                        if (map[tmpY][tmpX] == 1 && visited[tmpY][tmpX]==0) {
                            visited[tmpY][tmpX] = step;
                            q.offer(new Point(tmpY, tmpX, p.step + 1));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        visited = new int[height][width];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < height; i++) {
            String[] input = (br.readLine()).split("");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
//            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
//        searchDFS(0, 0, 1);
//        System.out.println(answer);


        searchBFS(0, 0, 1);
    }
}
