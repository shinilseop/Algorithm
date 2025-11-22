package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex09 {
    static int[][] sigmaV;

//    public static long sigma(int loop, int num) {
//        if(loop==1) {
//            return sigmaV[num];
//        }
//
//        long sum = 0;
//        for (int i = 1; i <= num; i++) {
//            sum += sigma(loop - 1, i);
//        }
//
//        return sum;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sigmaV = new int[31][31];
        for (int i = 1; i < sigmaV.length; i++) {
            sigmaV[0][i] = i;
        }
        for (int i = 1; i < sigmaV.length; i++) {
            for (int j = 1; j < sigmaV[i].length; j++) {
                sigmaV[i][j] += sigmaV[i][j-1]+sigmaV[i-1][j];
            }
        }

        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 20);

        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 1) {
                sb.append(m).append('\n');
            } else {
//                int[] tmp = Arrays.copyOf(sigmaV, sigmaV.length);
////                System.out.println(Arrays.toString(tmp));
//                for (int i = 0; i < n - 2; i++) {
//                    for (int j = 2; j <= m - n + 1; j++) {
//                        tmp[j] += tmp[j-1];
//                    }
////                    System.out.println(Arrays.toString(tmp));
//                }
//                sb.append(tmp[m-n+1]).append('\n');
                sb.append(sigmaV[n-1][m-n+1]).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
