package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_Repeat1 {
    static int BLACK = 0;
    static int WHITE = 1;
    static int[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = chars[j] == 'W' ? WHITE : BLACK;
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countChange(i, j, WHITE));
                min = Math.min(min, countChange(i, j, BLACK));
            }
        }

        System.out.println(min);
    }

    public static int countChange(int startY, int startX, int color) {
        int cnt = 0;
        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (color == board[i][j]) {
                    cnt++;
                }
                color = color == BLACK ? WHITE : BLACK;
            }
            color = color == BLACK ? WHITE : BLACK;
        }
        return cnt;
    }
}
