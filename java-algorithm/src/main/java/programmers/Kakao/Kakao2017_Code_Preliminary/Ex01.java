package programmers.Kakao.Kakao2017_Code_Preliminary;

public class Ex01 {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    boolean[][] visited;
    static int[][] map;

    public int dfs(int y, int x) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if (0 <= tmpX && tmpX < visited[0].length) {
                if (0 <= tmpY && tmpY < visited.length) {
                    if (!visited[tmpY][tmpX] && map[tmpY][tmpX] == map[y][x]) {
                        visited[tmpY][tmpX] = true;
                        cnt += dfs(tmpY, tmpX) + 1;
                    }
                }
            }
        }

        return cnt;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        map = picture;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j) + 1);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
