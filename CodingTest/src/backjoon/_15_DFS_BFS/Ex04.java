package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    static char[][] mapped;
    static boolean[][] visited;
    static int width, height;
    static int[] _x = {-1, 0, 1, 0}, _y = {0, -1, 0, 1};

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int tmpX = x+_x[i];
            int tmpY = y+_y[i];

            if (0 <= tmpX && tmpX < width) {
                if (0 <= tmpY && tmpY < height) {
                    if (mapped[tmpY][tmpX] == 1 && !visited[tmpY][tmpX]) {
                        visited[tmpY][tmpX] = true;
                        dfs(tmpY, tmpX);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(T * 3);

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            mapped = new char[height][width];
            visited = new boolean[height][width];
            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mapped[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (mapped[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
