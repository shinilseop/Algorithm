package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05_r {
    static final int MOD = 1000000007;

    public static long factorial(int n) {
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = (sum * i) % MOD;
        }
        return sum;
    }

    public static long expo(long value, long exp) {
        if (exp == 1) {
            return value % MOD;
        }

        long tmp = expo(value, exp / 2);
        if (exp % 2 == 0) {
            return tmp * tmp % MOD;
        } else {
            return (tmp * tmp % MOD) * value % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        long nFac = factorial(N) % MOD;
        long kFac = factorial(K) % MOD;
        long nkFac = factorial(N - K) % MOD;
        long result = (nFac * expo((kFac * nkFac) % MOD, MOD - 2)) % MOD;
        System.out.println(result);
    }
}
