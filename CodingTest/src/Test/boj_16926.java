package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926 {
    static int N, M, R;

    public static String[][] rotate(String[][] matrix) {
        String[][] result = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int start = 0; start < Math.min(N, M) / 2; start++) {
            for (int i = start; i < N - start - 1; i++) {
                int y = i + 1;
                int x = start;

                result[y][x] = matrix[i][x];
            }

            for (int i = start; i < M - start - 1; i++) {
                int y = N - start - 1;
                int x = i + 1;

                result[y][x] = matrix[y][i];
            }

            for (int i = N - start - 1; i >= start + 1; i--) {
                int y = i - 1;
                int x = M - start - 1;

                result[y][x] = matrix[i][x];
            }

            for (int i = M - start - 1; i >= start + 1; i--) {
                int y = start;
                int x = i - 1;

                result[y][x] = matrix[y][i];
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        String[][] matrix = new String[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < R; i++) {
            matrix = rotate(matrix);
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i <M; i++) {
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }
}
