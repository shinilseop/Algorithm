package programmers.SkillUp_Test.Level3_2;

import java.util.Arrays;

public class Ex01_3 {
    static final int MOD = 1234567;
    static boolean[] isNormal;

    public void divide(int num, int[] arr) {
        for (int i = 2; i <= num; i++) {
            if (!isNormal[i] && num % i == 0) {
                arr[i]++;
                num /= i;
                i--;
            }
        }
    }

    public long combi(int n, int k) {
        long sum = 1;
        if (n < k) {
            int tmp = n;
            n = k;
            k = tmp;
        }

        int[] ns = new int[n + 1];
        int[] ks = new int[n + 1];
        int[] nks = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            System.out.println(i+" cmp "+n+" "+k+" "+(n-k));
            if (i <= n) {
                System.out.println("ns");
                divide(i, ns);
            } else if (i <= k) {
                System.out.println("ks");
                divide(i, ks);
            } else if (i <= (n - k)) {
                System.out.println("nks");
                divide(i, nks);
            }
        }

        System.out.println(n+" "+k+" "+(n-k));
        System.out.println(Arrays.toString(ns));
        System.out.println(Arrays.toString(ks));
        System.out.println(Arrays.toString(nks));

        for (int i = 2; i <= n; i++) {
            if (ns[i] > 0) {
                ns[i] = ns[i] - ks[i] - nks[i];
                for (int j = 0; j < ns[i]; j++) {
                    sum = (sum * i) % MOD;
                }
            }
        }

        return sum;
    }

    public long solution(int n) {
        isNormal = new boolean[2001];
        isNormal[0] = true;
        isNormal[1] = true;
        for (int i = 2; i <= 2000; i++) {
            if (!isNormal[i]) {
                for (int j = i + i; j <= 2000; j += i) {
                    isNormal[j] = true;
                }
            }
        }

        long answer = 1;
        if (n % 2 == 0) {
            answer++;
            for (int i = 1; i < n / 2; i++) { // 2의 개수
                answer = (answer + combi(n + 1 - (i * 2), i)) % MOD;
            }
        } else {
            for (int i = 1; i <= n / 2; i++) { // 2의 개수
                answer = (answer + combi(n + 1 - (i * 2), i)) % MOD;
            }
        }

        return answer;
    }
}
