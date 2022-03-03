package backjoon._16_ShortestPath;

import java.io.*;
import java.util.*;

public class Ex06 {
    static int[][] time;

    static int N, M, K;
    static LinkedList<Node>[] edges;
    static final int INF = 1000000000;

    public static class Node implements Comparable<Node> {
        int idx, cost, time;

        public Node(int idx, int cost, int time) {
            this.idx = idx;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }

    public static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 큐에 진입 했으나 다른 우선순위의 노드가 실행되면서 최소값이 갱신 됬을 가능성이 있기에
            if(node.time > time[node.idx][node.cost])
                continue;

            for (Node next : edges[node.idx]) {
                if (node.cost + next.cost <= M && time[next.idx][node.cost + next.cost] > time[node.idx][node.cost]+next.time) {
                    time[next.idx][node.cost+next.cost] = time[node.idx][node.cost]+next.time;
                    pq.offer(new Node(next.idx, node.cost + next.cost, time[next.idx][node.cost + next.cost]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(T * 9);

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1][M + 1];
            edges = new LinkedList[N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(time[i], INF);
                edges[i] = new LinkedList<>();
            }


            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                edges[u].add(new Node(v, c, d));
            }

            Arrays.fill(time[1], 0);
            solve();
            int find = INF;
            for (int i = 1; i <= M; i++) {
                find = Math.min(find, time[N][i]);
            }

            sb.append(find == INF ? "Poor KCM" : find).append('\n');
        }

        System.out.print(sb.toString().strip());
    }
}
