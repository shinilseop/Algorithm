package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    static int[][] paper;
    static int size;
    static int[] paperCnt;

    public static void dividePaper(int y, int x, int len) {
//        System.out.println("START " + y + ", " + x + "=" + len + "(" + paper[y][x] + ")");
        if (len == 1) {
//            System.out.println("1 ADD " + paper[y][x]);
            paperCnt[paper[y][x]]++;
            return;
        }

        int stand = paper[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (paper[i][j] != stand) {
//                    System.out.println("DIFF = " + i + " " + j + " " + paper[i][j]);
//                    System.out.println();
                    dividePaper(y, x, len / 2);
                    dividePaper(y + (len / 2), x, len / 2);
                    dividePaper(y, x + (len / 2), len / 2);
                    dividePaper(y + (len / 2), x + (len / 2), len / 2);
                    return;
                }
            }
        }

//        System.out.println(len + " ADD " + paper[y][x]);
        paperCnt[paper[y][x]]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        paper = new int[size][size];
        paperCnt = new int[2];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, size);
        System.out.println(paperCnt[0]);
        System.out.println(paperCnt[1]);
    }
}
