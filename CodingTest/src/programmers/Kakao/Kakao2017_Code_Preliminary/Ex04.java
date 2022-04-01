package programmers.Kakao.Kakao2017_Code_Preliminary;

public class Ex04 {
    static final int MOD = 20170805;
    static int[][] map;
    static int[][][] dp;//y,x,dir
    static int m, n;
    static int[] dx = {1, 0}, dy = {0, 1}; //dir

    public class Move {
        int y, x, dir;

        public Move(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    public void dps() {
        dp[0][1][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    dp[i][j + 1][0] = (dp[i][j][0] + dp[i][j][1] + dp[i][j + 1][0]) % MOD;
                    dp[i + 1][j][1] = (dp[i][j][0] + dp[i][j][1] + dp[i + 1][j][1]) % MOD;
                } else if (map[i][j] == 2) {
                    dp[i][j + 1][0] = (dp[i][j][0] + dp[i][j + 1][0]) % MOD;
                    dp[i + 1][j][1] = (dp[i][j][1] + dp[i + 1][j][1]) % MOD;
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j][0]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j][1]+" ");
//            }
//            System.out.println();
//        }
    }

    public int solution(int m, int n, int[][] cityMap) {
        this.m = m;
        this.n = n;
        this.map = cityMap;
        dp = new int[m + 1][n + 1][dx.length];

        dps();

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }

    public static void main(String[] args) {
        Ex04 main = new Ex04();

        int map[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int map2[][] = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(main.solution(3, 3, map2));
    }
}
