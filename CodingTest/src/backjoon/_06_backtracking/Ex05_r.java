package backjoon._06_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05_r {
    static int[] queenHeightIdx;
    static int N, cnt;

    public static void dfsBatch(int idx) {
        if (idx == N+1) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (canBatch(idx, i)) {
                queenHeightIdx[idx] = i;
                dfsBatch(idx + 1);
            }
        }
    }

    public static boolean canBatch(int w, int h) {
        for (int i = 1; i < w; i++) {
            if (queenHeightIdx[i] == h) {
                return false;
            }

            int row = i - w;
            int col = queenHeightIdx[i] - h;
            if (Math.abs(row) == Math.abs(col)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queenHeightIdx = new int[N + 1];
        cnt = 0;

        dfsBatch(1);

        System.out.println(cnt);
    }
}
