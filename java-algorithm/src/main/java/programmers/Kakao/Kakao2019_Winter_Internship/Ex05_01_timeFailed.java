package programmers.Kakao.Kakao2019_Winter_Internship;

public class Ex05_01_timeFailed {
    public int solution(int[] stones, int k) {
        int dp[] = new int[stones.length + 1];
        for (int i = 0; i < k; i++) {
            dp[i] = stones[i];
        }
        dp[stones.length] = Integer.MAX_VALUE;

        for (int i = k; i <= stones.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= i - k; j--) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = Math.min(stones[i], max);
        }

        return dp[stones.length];
    }
}
