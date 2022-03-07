package programmers.high_scores._07_dynamic_programming;

public class Ex04 {
    public int solution(int[] money) {
        int[][] dp = new int[money.length][2];
        dp[0][0] = money[0];
        dp[0][1] = 0;
        dp[1][0] = money[1];
        dp[1][1] = money[0];
        for (int i = 2; i < dp.length-1; i++) {
            dp[i][0] = dp[i - 1][1] + money[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        int max1 = Math.max(dp[dp.length-2][0],Math.max(dp[dp.length-2][1],Math.max(dp[dp.length-1][0],dp[dp.length-1][1])));

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = money[1];
        dp[1][1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][1] + money[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        int max2 = Math.max(dp[dp.length-2][0],Math.max(dp[dp.length-2][1],Math.max(dp[dp.length-1][0],dp[dp.length-1][1])));

        return Math.max(max1, max2);
    }
}
