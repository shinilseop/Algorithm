package programmers.Kakao.Kakao2021_Blind_Recruitment;

import java.util.Arrays;

public class ex03_MergeTaxiCost {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6, s = 4, a = 6, b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(solution.solution(n, s, a, b, fares));
    }

    static class Solution {

        static int[][] dist;
        static int INF = Integer.MAX_VALUE / 2;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            dist = new int[n][n];
            s -= 1;
            a -= 1;
            b -= 1;

            for (int i = 0; i < dist.length; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int[] fare : fares) {
                dist[fare[0] - 1][fare[1] - 1] = fare[2];
                dist[fare[1] - 1][fare[0] - 1] = fare[2];
            }

            floyd(dist);

//            for (int i = 0; i < dist.length; i++) {
//                System.out.println(Arrays.toString(dist[i]));
//            }

            int answer = INF;
            for (int i = 0; i < dist.length; i++) {
                answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
            }


            return answer;
        }

        public void floyd(int[][] dist) {
            for (int k = 0; k < dist.length; k++) {
                for (int i = 0; i < dist.length; i++) {
                    for (int j = 0; j < dist.length; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}
