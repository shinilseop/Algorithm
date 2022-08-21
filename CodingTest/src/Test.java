import java.util.*;
import java.io.*;

public class Test {
    static int N;
    static boolean[] visited;
    public static void comb(int idx, int cnt) {
        if (cnt == N / 2) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(i);
                }
            }
            System.out.println();
        }

        if (idx >= visited.length) {
            return;
        }

        visited[idx] = true;
        comb(idx + 1, cnt + 1);
        visited[idx] = false;
        comb(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        comb(0, 0);
    }
}
