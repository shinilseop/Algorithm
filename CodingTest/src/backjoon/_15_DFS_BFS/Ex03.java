package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex03 {
    static boolean[][] mapped, visited;
    static int size;
    static int[] _x = {-1, 0, 1, 0}, _y = {0, -1, 0, 1};

    public static int dfs(int y, int x) {
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int tmpX = x + _x[i];
            int tmpY = y + _y[i];

            if (0 <= tmpX && tmpX < size) {
                if (0 <= tmpY && tmpY < size) {
                    if (mapped[tmpY][tmpX] && !visited[tmpY][tmpX]) {
                        visited[tmpY][tmpX] = true;
                        cnt += dfs(tmpY, tmpX);
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        mapped = new boolean[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] str = (br.readLine()).split("");
            for (int j = 0; j < size; j++) {
                mapped[i][j] = Integer.parseInt(str[j])==1;
            }
        }

        int cnt = 0;
        ArrayList<Integer> cnts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mapped[i][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    cnts.add(dfs(i, j));
                }
            }
        }
        Collections.sort(cnts);
        sb.append(cnt).append('\n');
        for (Integer tmp : cnts) {
            sb.append(tmp).append('\n');
        }

        System.out.print(sb.toString());
    }
}
