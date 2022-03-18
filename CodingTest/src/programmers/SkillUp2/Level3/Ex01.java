package programmers.SkillUp2.Level3;

import java.util.Arrays;

public class Ex01 {
    static int[] parent;

    public int findParent(int node) {
        if (parent[node] == node) return node;
        return findParent(parent[node]);
    }

    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    int from = i;
                    int to = j;

                    int fromParent = findParent(from);
                    int toParent = findParent(to);
                    if (fromParent == toParent) continue;

                    parent[toParent] = fromParent;
                }
            }
        }


        int network = 0;
        boolean[] isFind = new boolean[n];
        for (int i = 0; i < n; i++) {
            int iParent=findParent(i);
            if (!isFind[iParent]) {
                isFind[iParent] = true;
                network++;
            }
        }

        return network;
    }
}
