package backjoon._01_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        if (N == 1 || N == 2 || N == 4 || N == 7) {
//            System.out.println(-1);
//        } else {
//            int pack5 = N / 5;
//            int remain = N % 5;
//            if (remain == 0) {
//                System.out.println(pack5);
//            } else {
//                if (remain == 1 || remain == 3) {
//                    System.out.println(pack5 + 1);
//                } else {
//                    System.out.println(pack5 + 2);
//                }
//            }
//        }

        int cnt = 0;
        while (true) {
            if (N % 5 == 0) {
                cnt+=(N/5);
                break;
            } else if (N < 3) {
                cnt=-1;
                break;
            }
            cnt++;
            N-=3;
        }

        System.out.println(cnt);
    }
}