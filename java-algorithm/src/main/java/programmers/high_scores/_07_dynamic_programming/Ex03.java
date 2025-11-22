package programmers.high_scores._07_dynamic_programming;

import java.util.ArrayList;

public class Ex03 {
    static int[][] dist;
    static boolean[][] isPuddle;
    static int N, M;
    static ArrayList<Point> path;
    static final int MOD = 1000000007;

    public static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void dfs(Point now) {
//        System.out.println(now.y + " " + now.x);
        if (now.y == N - 1 && now.x == M - 1) {
//            System.out.println("LAST");
            addPath(1);
            return;
        }

        if (now.x + 1 < M) {
            if (!isPuddle[now.y][now.x + 1]) {
                if (dist[now.y][now.x + 1] != 0) {
//                    System.out.println("x EXIST : " + now.y + " " + (now.x+1) + ":" + dist[now.y][now.x + 1]);
                    addPath(dist[now.y][now.x + 1]);
                } else {
//                    System.out.println("x MOVE : " + now.y + " " + (now.x+1) + ":" + dist[now.y][now.x + 1]);
                    Point tmp = new Point(now.y, now.x + 1);
                    path.add(tmp);
                    dfs(tmp);
                    path.remove(path.size() - 1);
                }
            }
        }

        if (now.y + 1 < N) {
            if (!isPuddle[now.y + 1][now.x]) {
                if (dist[now.y + 1][now.x] != 0) {
//                    System.out.println("y EXIST : " + (now.y+1) + " " + now.x + ":" + dist[now.y + 1][now.x]);
                    addPath(dist[now.y + 1][now.x]);
                } else {
//                    System.out.println("y MOVE : " + (now.y+1) + " " + now.x + ":" + dist[now.y + 1][now.x]);
                    Point tmp = new Point(now.y + 1, now.x);
                    path.add(tmp);
                    dfs(tmp);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void addPath(int num) {
        for (Point p : path) {
//            System.out.println("ADD : " + p.y + " " + p.x + ":" + num);
            dist[p.y][p.x] += num;
        }
    }

    public static void school_to_home() {
        dist[N - 1][M - 1] = 1;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (!isPuddle[i][j]) {
                    if (i + 1 < N && j + 1 < M) {
                        dist[i][j] = (dist[i][j + 1] + dist[i + 1][j])%MOD;
                    } else if (i + 1 < N) {
                        dist[i][j] = dist[i + 1][j];
                    } else if (j + 1 < M) {
                        dist[i][j] = dist[i][j + 1];
                    }
                }
            }
        }
    }

    public static int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        dist = new int[N][M];
        isPuddle = new boolean[N][M];
        for (int i = 0; i < puddles.length; i++) {
            isPuddle[puddles[i][1]-1][puddles[i][0]-1] = true;
        }

        school_to_home();

        return dist[0][0];
    }

    public static void main(String[] args) {
//        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(solution(4, 3, new int[][]{{3,2}, {3,3}}));
    }
}
