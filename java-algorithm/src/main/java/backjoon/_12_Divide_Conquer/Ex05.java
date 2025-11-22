package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05 {
    static int n, k;
    static final int MOD = 1000000007;

    public static long factorial(int num, int end) {
        long sum = 1;

        while (num > end) {
            sum = (sum * num) % MOD;
            num--;
        }

        return sum;
    }

    public static long pow(long num, int exp) {
        if (exp == 1) {
            return num%MOD;
        }

        long tmp = pow(num, exp / 2);

        if (exp % 2 == 0) {
            return (tmp * tmp) % MOD;
        } else {
            return ((tmp * tmp) % MOD) * num % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        long numer = factorial(n, k);
        long demon = factorial(n-k, 1);

        System.out.println(numer*pow(demon, MOD-2)%MOD);
    }
}
