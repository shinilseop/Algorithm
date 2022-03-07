package programmers.high_scores._07_dynamic_programming;

import java.util.Arrays;

public class Ex01 {
    static int min = Integer.MAX_VALUE;
    static int N, number;
    static int[] dp;

    public static void dfs(int num, int step) {
//        System.out.println(num+" "+step);
        if (step > 8) {
            return;
        } else if (num == number) {
            min = Math.min(min, step);
            return;
        } else if (num < 0 && num > number*N) {
            return;
        }

        for (int i = 1; i + step <= 8; i++) {
            int tmp = N;

            for (int j = 1; j < i; j++) {
                tmp = tmp * 10 + N;
            }

            // 기본
            dfs(num * (int) Math.pow(10, i) + tmp, step + i); // 이어 붙이기
            dfs(num / tmp, step + i); // 나누기
            dfs(num * tmp, step + i); // 곱하기
            dfs(num + tmp, step + i); // 더하기
            dfs(num - tmp, step + i); // 빼기

            if (i + step < 8) {
                int div = N;
                dfs(num + (tmp / div), step + i + 1);
                dfs(num - (tmp / div), step + i + 1);
                dfs(num * (tmp / div), step + i + 1);
                dfs(num / (tmp / div), step + i + 1);
                for (int j = 2; j + i + step <= 8; j++) {
                    div = div * 10 + N;
                    if (tmp / div == 0) {
                        continue;
                    }
                    dfs(num + (tmp / div), step + i + j);
                    dfs(num - (tmp / div), step + i + j);
                    dfs(num * (tmp / div), step + i + j);
                    dfs(num / (tmp / div), step + i + j);
                }
            }
        }
    }

    public static int solution(int _N, int _number) {
        number = _number;
        N = _N;
        dp = new int[N * number * N + 1];
        Arrays.fill(dp, 1000000000);

        dfs(N, 1);

        return min > 8 ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 10101));
    }
}
