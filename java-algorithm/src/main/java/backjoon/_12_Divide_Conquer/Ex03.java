package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex03 {
    static int[][] paper;
    static int size;
    static int[] cnt;

    public static void dividePaper(int y, int x, int len) {
        if (len == 1) {
            cnt[paper[y][x]]++;
            return;
        }

        int stand = paper[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (stand != paper[i][j]) {
                    for (int k = 0; k < 3; k++) {
                        for (int t = 0; t < 3; t++) {
                            dividePaper(y+(len/3)*k, x+(len/3)*t, len/3);
                        }
                    }
                    return;
                }
            }
        }

        cnt[stand]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        paper = new int[size][size];
        cnt = new int[3];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    num = 2;
                }
                paper[i][j] = num;
            }
        }

        dividePaper(0, 0, size);
        System.out.println(cnt[2]);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }
}
