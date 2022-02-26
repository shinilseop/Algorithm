package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonachiTest {
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long result = 0;
        long tmp[] = new long[2];
        tmp[0] = 0;
        tmp[1] = 1;
        for (int i = 2; i <= num; i++) {
            result = (tmp[0]+tmp[1])%MOD;
            tmp[0] = tmp[1];
            tmp[1] = result;
//            System.out.printf("%10d : %50d\n", i, result);
        }

        System.out.println(result);
    }
}
