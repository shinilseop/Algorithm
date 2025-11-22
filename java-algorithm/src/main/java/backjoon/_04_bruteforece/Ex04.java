package backjoon._04_bruteforece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    public static int countingDraw(int startI, int startJ, char chess[][], boolean isBlack) {
        int tmpDraw = 0;

        for (int i = startI; i < startI + 8; i++) {
            for (int j = startJ; j < startJ + 8; j++) {
                if (isBlack && chess[i][j] != 'B') {
                    tmpDraw++;
//                    System.out.printf("re draw:");
                } else if (!isBlack && chess[i][j] != 'W') {
                    tmpDraw++;
//                    System.out.printf("re draw:");
                }
//                System.out.println(i + " " + j + " : " + chess[i][j] + " " + isBlack + " (" + tmpDraw + ")");
                isBlack = !isBlack;
            }

            isBlack = !isBlack;
        }

        return tmpDraw;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char chess[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            String chessTmp = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i][j] = chessTmp.charAt(j);
//                System.out.print(chess[i][j]+" ");
            }
//            System.out.println();
        }

        /**
         * 왼쪽 위 모서리의 칸이
         * 1. B 일떄==>0
         * 2. W 일때==>1
         */
        int minDraw = Math.min(countingDraw(0,0,chess,true), countingDraw(0,0,chess,false));

        for (int i = 0; i <= chess.length - 8; i++) {
            for (int j = 0; j <= chess[i].length - 8; j++) {
//                System.out.println(i+" "+j);
                minDraw = Math.min(minDraw, Math.min(countingDraw(i,j,chess,true), countingDraw(i,j,chess,false)));
//                System.out.println(minDraw);
            }
        }

        System.out.println(minDraw);
    }
}
