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

    
    // 속도+효율 굳
    public int solution2(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[0] + money[2]);
        for (int i = 3; i < money.length-1; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + money[i], dp[i - 3] + money[i]));
        }
        int max1 = Math.max(dp[money.length - 1], Math.max(dp[money.length - 2], dp[money.length - 3]));

        dp = new int[money.length];
        dp[0] = 0;
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < money.length; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + money[i], dp[i - 3] + money[i]));
        }
        int max2 = Math.max(dp[money.length - 1], Math.max(dp[money.length - 2], dp[money.length - 3]));

        return Math.max(max1, max2);
    }
}
