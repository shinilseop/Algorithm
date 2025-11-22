package programmers.another;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2020 카카오 인턴십
 * 경주로 건설
 */
public class Kakao_2020_intership_build_course_failed {

    public final int INF = 1000000000;

    public class Road implements Comparable<Road> {
        int money;
        int y, x;
        boolean isWidth;
        boolean check;

        public Road(int money, int y, int x, boolean isWidth, boolean check) {
            this.money = money;
            this.y = y;
            this.x = x;
            this.isWidth = isWidth;
            this.check = check;
        }

        @Override
        public int compareTo(Road road) {
            return this.money - road.money;
        }
    }

    public int solution(int[][] board) {
//        boolean[][]
        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) Arrays.fill(dp[i], INF);

        PriorityQueue<Road> pq = new PriorityQueue<>();
        dp[0][0] = 0;
        if (board[0][1] == 0) {
            dp[0][1] = 100;
            pq.add(new Road(100, 0, 1, true, true));
        }
        if (board[1][0] == 0) {
            dp[1][0] = 100;
            pq.add(new Road(100, 1, 0, false, true));
        }

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        while (!pq.isEmpty()) {
            Road now = pq.poll();
            System.out.println("=========================================");
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (dp[i][j] == INF) {
                        if (board[i][j] == 0)
                            System.out.print("     0");
                        else
                            System.out.print("------");
                    } else {
                        System.out.printf("%6d", dp[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println();

            if (now.y == board.length - 1 && now.x == board[0].length - 1) {
                continue;
            }

            if (dp[now.y][now.x] < now.money) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = now.x + dx[i];
                int tmpY = now.y + dy[i];

                if (0 <= tmpX && tmpX < board[0].length) {
                    if (0 <= tmpY && tmpY < board.length) {
                        int cost = 0;
                        boolean moveWidth = false;
                        if (tmpX != now.x && now.isWidth) {
                            cost = 100;
                            moveWidth = true;
                        } else if (tmpX != now.x && !now.isWidth) {
                            cost = 600;
                            moveWidth = true;
                        } else if (tmpY != now.y && now.isWidth) {
                            cost = 600;
                            moveWidth = false;
                        } else if (tmpY != now.y && !now.isWidth) {
                            cost = 100;
                            moveWidth = false;
                        }

                        if (board[tmpY][tmpX] == 0 && dp[tmpY][tmpX] >= now.money + cost) {
                            dp[tmpY][tmpX] = now.money + cost;
                            pq.add(new Road(dp[tmpY][tmpX], tmpY, tmpX, moveWidth, true));
                        } else if (board[tmpY][tmpX] == 0 && now.check && dp[tmpY][tmpX] + 500 >= now.money + cost) {
                            System.out.println(tmpY+" "+tmpX+">> "+dp[tmpY][tmpX]+" "+(now.money + cost));
                            pq.add(new Road(dp[tmpY][tmpX], tmpY, tmpX, moveWidth, false));
                        }
                    }
                }
            }
        }

        return dp[board.length - 1][board[0].length - 1];
    }

    public static void main(String[] args) throws IOException {
        Kakao_2020_intership_build_course_failed main = new Kakao_2020_intership_build_course_failed();
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
