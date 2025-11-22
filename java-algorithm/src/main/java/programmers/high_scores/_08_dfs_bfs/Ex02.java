package programmers.high_scores._08_dfs_bfs;

import java.util.HashMap;
import java.util.LinkedList;

public class Ex02 {
    static HashMap<Integer, Integer> group;
    static LinkedList<Integer>[] edges;
    static int N;

    public static void dfs(int start, int groupNum) {
        for (Integer next : edges[start]) {
            if (!group.containsKey(next)) {
                group.put(next, groupNum);
                dfs(next, groupNum);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        N = n;
        group = new HashMap<>();
        edges = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new LinkedList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if(computers[i][j]==1) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int groupNum = 0;
        for (int i = 0; i < N; i++) {
            if (!group.containsKey(i)) {
                group.put(i, ++groupNum);
                dfs(i, groupNum);
            }
        }

        return groupNum;
    }
}
