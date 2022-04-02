package Test_Result.dev_first_half_2022;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01 {
    static boolean[] visited;
    static int[][] dist;
    ArrayList<int[]> answerList;

    public void dfs(int[] batch, int len) {
        if (batch.length == len) {
            answerList.add(Arrays.copyOf(batch, batch.length));
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            batch[len] = i;
            if (!visited[i] && isPossible(batch, len)) {
                visited[i] = true;
                dfs(batch,len+1);
                visited[i]=false;
            }
            batch[len] = -1;
        }
    }

    public boolean isPossible(int[] batch, int len) {
        for (int i = 0; i < len; i++) {
            int d = 0;
            for (int j = i + 1; j <= len; j++) {
                d+=dist[batch[j-1]][batch[j]];
                if (dist[batch[i]][batch[j]] != d) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] solution(int[][] dist) {
        answerList = new ArrayList<>();
        visited = new boolean[dist.length];
        this.dist=dist;

        int[] batch = new int[dist.length];
        Arrays.fill(batch, -1);
        dfs(batch, 0);

        int[][] answer = new int[answerList.size()][dist.length];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

//    dist	result
//[[0,5,2,4,1],[5,0,3,9,6],[2,3,0,6,3],[4,9,6,0,3],[1,6,3,3,0]]	[[1,2,0,4,3],[3,4,0,2,1]]
//        [[0,2,3,1],[2,0,1,1],[3,1,0,2],[1,1,2,0]]	[[0,3,1,2],[2,1,3,0]]