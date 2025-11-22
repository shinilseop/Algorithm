package programmers.SkillUp2.Level3;

import java.util.Arrays;
import java.util.LinkedList;

public class Ex02 {
    static final int INF = 1000000000;
    static int[][] dist;

    public void minDist(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            dist[loser][winner] = 1;
        }

        minDist(n);

        for (int i = 1; i <= n; i++) {
            boolean isNown = true;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF && dist[j][i] == INF) {
                    isNown = false;
                    break;
                }
            }

            if (isNown) {
                answer++;
            }
        }

        return answer;
    }
}
