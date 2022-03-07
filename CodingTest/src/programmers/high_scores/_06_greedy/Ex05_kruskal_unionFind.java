package programmers.high_scores._06_greedy;

import java.util.Arrays;

// kruskal & union Find 알고리즘
public class Ex05_kruskal_unionFind {
    static int[] parent;

    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs, (arr1, arr2) -> arr1[2] - arr2[2]);

        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        System.out.println(Arrays.toString(parent));
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            int fromParent = findParent(from);
            int toParent = findParent(to);
            if(fromParent==toParent) continue;

            sum+=cost;
            parent[toParent] = fromParent;

            System.out.println(from+" "+to+" "+cost);
            System.out.println(Arrays.toString(parent));
        }

        return sum;
    }

    public static int findParent(int node) {
        if(parent[node] == node) return node;
        return findParent(parent[node]);
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}
