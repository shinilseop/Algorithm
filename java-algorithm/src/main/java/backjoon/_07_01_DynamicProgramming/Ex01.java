package backjoon._07_01_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    static int fiboCount[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int _loop = Integer.parseInt(br.readLine());
        int[] arr = new int[_loop];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        fiboCount = new int[max + 1][2];
        fiboCount[0][0] = 1;
        fiboCount[0][1] = 0;
        fiboCount[1][0] = 0;
        fiboCount[1][1] = 1;
        for (int i = 2; i < fiboCount.length; i++) {
            fiboCount[i][0] = fiboCount[i-2][0] + fiboCount[i-1][0];
            fiboCount[i][1] = fiboCount[i-2][1] + fiboCount[i-1][1];
        }

        StringBuffer sb = new StringBuffer(_loop * 4);
        for (int i = 0; i < arr.length; i++) {
            sb.append(fiboCount[arr[i]][0]).append(' ').append(fiboCount[arr[i]][1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
