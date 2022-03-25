package programmers.KakaoInternship2020;

import java.io.IOException;
import java.util.Arrays;

/**
 * 2020 카카오 인턴십
 * 경주로 건설
 */
public class Ex02_Kakao_2020_intership_build_course_DFS {

    public final int INF = 1000000000;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[][] dp, board;
    static boolean[][] visited;

    public void dfs(int y, int x, int money, boolean isWidth) {
        dp[y][x] = Math.min(dp[y][x], money);
        if (y == board.length - 1 && x == board[0].length - 1) {
            return;
        }

        if (dp[y][x] + 500 <= money) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (0 <= tmpX && tmpX < board[0].length) {
                if (0 <= tmpY && tmpY < board.length) {
                    int cost = 0;
                    boolean moveWidth = false;
                    if (tmpX != x && isWidth) {
                        cost = 100;
                        moveWidth = true;
                    } else if (tmpX != x && !isWidth) {
                        cost = 600;
                        moveWidth = true;
                    } else if (tmpY != y && isWidth) {
                        cost = 600;
                        moveWidth = false;
                    } else if (tmpY != y && !isWidth) {
                        cost = 100;
                        moveWidth = false;
                    }

                    if (!visited[tmpY][tmpX] && board[tmpY][tmpX] == 0) {
                        visited[tmpY][tmpX] = true;
                        dfs(tmpY, tmpX, money + cost, moveWidth);
                        visited[tmpY][tmpX] = false;
                    }
                }
            }
        }
    }

    public int solution(int[][] b) {
        board=b;
        dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) Arrays.fill(dp[i], INF);

        dp[0][0] = 0;
        visited = new boolean[board.length][board[0].length];
        if (board[0][1] == 0) {
            dp[0][1] = 100;
            visited[0][1] = true;
            dfs(0, 1, 100, true);
            visited[0][1] = false;
        }
        if (board[1][0] == 0) {
            dp[1][0] = 100;
            visited[0][1] = true;
            dfs(1, 0, 100, false);
            visited[0][1] = false;
        }

        return dp[board.length - 1][board[0].length - 1];
    }

    public static void main(String[] args) throws IOException {
        Ex02_Kakao_2020_intership_build_course_DFS main = new Ex02_Kakao_2020_intership_build_course_DFS();
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0}};
        System.out.println("ANSWER : " + main.solution(board2));
    }
}
