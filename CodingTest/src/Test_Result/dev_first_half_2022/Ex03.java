package Test_Result.dev_first_half_2022;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex03 {
    static boolean visited[];
    static LinkedList<Edge>[] edges;
    static ArrayList<Edge> path;
    static int k;
    static int a, b;

    public class Edge {
        int from, to;
        boolean isUsed;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
            this.isUsed = false;
        }
    }

    public void dfs(int now, int dist) {
        if (now == b) {
            for (int i = 0; i < path.size(); i++) {
                path.get(i).isUsed=true;
            }
            return;
        }

        if (dist >= k) {
            return;
        }

        for (Edge nextE : edges[now]) {
            int next = nextE.from == now? nextE.to:nextE.from;
            if (!visited[next]) {
                visited[next] = true;
                path.add(nextE);
                dfs(next, dist + 1);
                path.remove(path.size()-1);
                visited[next] = false;
            }
        }
    }

    public int solution(int n, int[][] edges, int k, int a, int b) {
        this.k = k;
        this.a = a;
        this.b = b;
        this.edges = new LinkedList[n];
        Edge[] useCheck = new Edge[edges.length];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) this.edges[i] = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            useCheck[i] = new Edge(from, to);
            this.edges[from].add(useCheck[i]);
            this.edges[to].add(useCheck[i]);
        }

        path = new ArrayList<>();
        visited[a] = true;
        dfs(a, 0);

        int answer = 0;
        
        for (int i = 0; i < useCheck.length; i++) {
            if (useCheck[i].isUsed) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
        Ex03 main = new Ex03();
        System.out.println(main.solution(8, edges,4,0,3));
    }
}
