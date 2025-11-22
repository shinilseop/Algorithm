package programmers.high_scores._06_greedy;

import java.util.Arrays;

public class Ex06 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (arr1, arr2) -> arr1[1] - arr2[1]);
        int cameraIdx = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            if (cameraIdx < routes[i][0]) {
                cameraIdx = routes[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
