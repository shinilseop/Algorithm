package programmers.high_scores._10_graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Ex02 {
    static final int INF = 1000000000;
    static int[][] dist;

    public void floydWarshall() {
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public int solution(int n, int[][] results) {
        dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i]=0;
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            dist[loser][winner]=1;
        }

        floydWarshall();
        for (int i = 1; i < dist.length; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        int answer = n;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == INF && dist[j][i] == INF) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
}
