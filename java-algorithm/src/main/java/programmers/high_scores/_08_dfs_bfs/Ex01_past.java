package programmers.high_scores._08_dfs_bfs;

public class Ex01_past {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);

        return answer;
    }
    public int dfs(int[] numbers, int level, int sum, int target){
        if(level == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, level+1, sum+numbers[level], target) + dfs(numbers, level+1, sum-numbers[level], target);
    }
}
