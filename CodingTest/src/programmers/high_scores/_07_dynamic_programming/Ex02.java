package programmers.high_scores._07_dynamic_programming;

public class Ex02 {
    public static int solution(int[][] triangle) {
        int max = -1;

        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] = triangle[i-1][0] + triangle[i][0];
            max = Math.max(max, triangle[i][0]);
            for (int j = 1; j < triangle[i].length-1; j++) {
                triangle[i][j] = Math.max(triangle[i-1][j], triangle[i-1][j-1]) + triangle[i][j];
                max = Math.max(max, triangle[i][j]);
            }
            triangle[i][triangle[i].length-1] = triangle[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
            max = Math.max(max, triangle[i][triangle[i].length-1]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}
