package programmers.SkillUp_Test.Level3_2;

public class Ex01 {
    static final int MOD = 1234567;

    static long factorial(int n) {
        long sum = 1;

        for (int i = 1; i <= n; i++) {
            sum = (sum * i) % MOD;
        }

        return sum;
    }

    public long combi(int n, int k) {
        System.out.println(n + " " + k + " " + (n - k));
        if (n <= k) {
            return 1;
        }
        long nFac = factorial(n);
        long kFac = factorial(k);
        long nkFac = factorial(n - k);
        System.out.println(nFac+" "+kFac+" "+nkFac);

        return (nFac * pow((kFac * (nkFac)) % MOD, MOD - 2)) % MOD;
    }

    public long pow(long value, long exp) {
        if (exp == 1) {
            return value % MOD;
        }

        long tmp = pow(value, exp / 2);
        if (exp % 2 == 0) {
            return (tmp * tmp) % MOD;
        } else {
            return (((tmp * tmp) % MOD) * value) % MOD;
        }
    }

    public long solution(int n) {
        long answer = 0;

        for (int i = 0; i <= n / 2; i++) {
            System.out.print((n + 1 - (i * 2)) +" "+ i+":");
            System.out.println((n + 1 - (i * 2)) +" "+ i);
            long value = combi(n + 1 - (i * 2), i);
            answer = (answer + value) % MOD;
        }

        return answer;
    }
}
