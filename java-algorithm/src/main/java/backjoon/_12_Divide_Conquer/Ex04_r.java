package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04_r {
    public static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long tmp = pow(A, B / 2, C);
        if (B % 2 == 0) {
            return (tmp * tmp) % C;
        } else {
            return (tmp * tmp % C) * A % C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.print(pow(A, B, C));
    }
}
