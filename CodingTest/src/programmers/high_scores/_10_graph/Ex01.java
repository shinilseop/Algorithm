package programmers.high_scores._10_graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Ex01 {
    static final int INF = 1000000000;
    static int[] dist;
    static boolean[] visited;
    static LinkedList<Node>[] edges;
    static int N, maxDist;

    public class Node implements Comparable<Node> {
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            dist[node.idx] = Math.min(dist[node.idx], node.weight);
            maxDist = Math.max(maxDist, dist[node.idx]);

            for (Node next : edges[node.idx]) {
                if (!visited[next.idx]) {
                    visited[next.idx] = true;
                    pq.add(new Node(next.idx, node.weight + next.weight));
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        N = n;
        dist = new int[N + 1];
        edges = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
            edges[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];

            edges[from].add(new Node(to, 1));
            edges[to].add(new Node(from, 1));
        }

        bfs(1);
        int cnt = 0;
        for (int i = 0; i < dist.length; i++) {
            if (maxDist == dist[i]) cnt++;
        }

        return cnt;
    }
}
