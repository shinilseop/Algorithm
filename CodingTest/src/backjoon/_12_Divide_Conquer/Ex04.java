package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    static long A, B, C;

    public static long loop(long exp) {
        if (exp == 1) {
            return A % C;
        }

        long tmp = loop(exp / 2);

        if (exp % 2 == 1) {
            return (tmp * tmp % C) * A % C;
        } else {
            return (tmp * tmp % C);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(loop(B));
    }
}
