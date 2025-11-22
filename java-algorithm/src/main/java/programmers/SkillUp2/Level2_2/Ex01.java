package programmers.SkillUp2.Level2_2;

public class Ex01 {
    public int solution2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1] + 1);
            } else {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            }
        }

        return dp[n];
    }

    public int solution(int n) {
        int cnt = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                cnt++;
            }
            n/=2;
        }

        return cnt;
    }
}
