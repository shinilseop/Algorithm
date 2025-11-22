package backjoon._09_Number_Combination_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11 {
    static boolean[] isPrime;
    static int[] primes;

    public static void factorization(int[] primes, int num) {
        for (int i = 2; i <= num; i++) {
            if (isPrime[i] && (num % i == 0)) {
                primes[i]++;
                num/=i;
                i--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        isPrime = new boolean[501];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        primes = new int[501];
        for (int i = 2; i <= num; i++) {
            factorization(primes, i);
        }

        System.out.println(Math.min(primes[2], primes[5]));
    }
}
