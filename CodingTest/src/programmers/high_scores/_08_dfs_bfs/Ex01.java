package programmers.high_scores._08_dfs_bfs;

public class Ex01 {
    static int[] number;
    static int target, cnt;
    static boolean[] visited;

    public void dfs(int sum, int idx) {
        if (idx == number.length-1) {
            if(sum == target)
                cnt++;
        } else {
            dfs(sum + number[idx], idx + 1);
            dfs(sum - number[idx], idx + 1);
        }
    }


    public int solution(int[] numbers, int target) {
        number = numbers;
        Ex01.target = target;
        cnt = 0;
        visited = new boolean[number.length];

        dfs(0, 0);

        return cnt;
    }
}
