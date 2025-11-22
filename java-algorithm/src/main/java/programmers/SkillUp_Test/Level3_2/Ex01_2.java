package programmers.SkillUp_Test.Level3_2;

import java.util.Arrays;

public class Ex01_2 {
    static final int MOD = 1234567;
    static boolean[] isNormal;

    public void divide(int num, int[] arr) {
        System.out.println(num);
        for (int i = 2; i <= num; i++) {
            if (!isNormal[i] && num % i == 0) {
                System.out.println(num+" "+i);
                arr[i]++;
                num /= i;
                i--;
            }
        }
    }

    public long combi(int n, int k) {
        System.out.println(n+" "+k);
        if (n < k) {
            int tmp = n;
            n = k;
            k = tmp;
        }

        int[] ns = new int[n+1];
        int[] ks = new int[n+1];
        int[] nks = new int[n+1];

        //
        for (int i = 2; i<=n;i++) {
            divide(i, ns);
        }
        for (int i = 2; i <= k; i++) {
            divide(i, ks);
        }
        for (int i = 2; i <= n-k; i++) {
            divide(i, nks);
        }

        System.out.println(Arrays.toString(ns));
        System.out.println(Arrays.toString(ks));
        System.out.println(Arrays.toString(nks));

        // 계산
        long sum = 1;
        for (int i = 2; i < ns.length; i++) {
            if (ns[i] > 0) {
                ns[i] = ns[i] - ks[i] - nks[i];
                for (int j = 0; j < ns[i]; j++) {
                    sum = (sum * i) % MOD;
                }
            }
        }

        System.out.println("result : "+sum);
        return sum;
    }

    public long solution(int n) {
        long answer = 0;

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

        answer++;
        if (n % 2 == 0) {
            answer++;
            for (int i = 1; i < n / 2; i++) {
                answer = (answer + combi(n + 1 - (i * 2), i)) % MOD;
            }
        } else {
            for (int i = 1; i <= n / 2; i++) {
                answer = (answer + combi(n + 1 - (i * 2), i)) % MOD;
            }
        }

        return answer;
    }
}
