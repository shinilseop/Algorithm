package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex10 {
    static int[][] chess;
    static boolean[][] visited;
    static int size;
    static StringBuffer answer;
    static int[] dx = {-2, -1, 1, 2}, dy[] = {{-1, 1}, {-2, 2}, {-2, 2}, {-1, 1}};

    public static class Point {
        int y, x, step;

        public Point(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

    public static void bfs(Point start, Point key) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == key.y && p.x == key.x) {
                answer.append(p.step).append('\n');
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                for (int j = 0; j < dy[i].length; j++) {
                    int tmpY = p.y+dy[i][j];
                    int tmpX = p.x+dx[i];

                    if (0 <= tmpY && tmpY < size) {
                        if (0 <= tmpX && tmpX < size) {
                            if (!visited[tmpY][tmpX]) {
                                visited[tmpY][tmpX] = true;
                                q.offer(new Point(tmpY, tmpX, p.step + 1));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new StringBuffer(T * 3);

        while (T-- > 0) {
            size = Integer.parseInt(br.readLine());
            chess = new int[size][size];
            visited = new boolean[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine(), " ");
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            bfs(start, end);
        }

        System.out.print(answer);
    }
}
