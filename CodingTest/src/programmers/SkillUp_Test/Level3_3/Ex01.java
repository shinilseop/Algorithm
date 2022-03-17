package programmers.SkillUp_Test.Level3_3;

import java.util.Arrays;
import java.util.LinkedList;

public class Ex01 {
    static int[][] costs;
    static final int INF = Integer.MAX_VALUE/3;

    public void minCosts(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        costs = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(costs[i], INF);
            costs[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];

            costs[from][to] = cost;
            costs[to][from] = cost;
        }

        minCosts(n);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(costs[i]));
            min = Math.min(min, costs[s][i] + costs[i][a] + costs[i][b]);
        }

        return min;
    }
}
