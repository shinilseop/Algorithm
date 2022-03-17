package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex06_r {
    static int[][] timeDP;
    static final int INF = 1000000000;
    static int N, M, K;
    static int minTime;
    static Node[] nodes;
    static LinkedList<Node>[] edges;

    public static class Node implements Comparable<Node> {
        int idx;
        int cost;
        int time;

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

    public static void dfs(Node now) {
        if (now.idx == N) {
            minTime = Math.min(minTime, now.cost);
            return;
        }

        for (Node next : edges[now.idx]) {
            int need = now.cost + next.cost;
            if (need <= M) {
                if (timeDP[next.idx][need] > timeDP[now.idx][now.cost] + next.time) {
                    timeDP[next.idx][need] = timeDP[now.idx][now.cost] + next.time;
                    dfs(new Node(next.idx, need, timeDP[next.idx][need]));
                } else if (timeDP[next.idx][need] == timeDP[now.idx][now.cost] + next.time) {
                    if (timeDP[next.idx][need] > timeDP[now.idx][now.cost] + next.time) {
                        timeDP[next.idx][need] = timeDP[now.idx][now.cost] + next.time;
                        dfs(new Node(next.idx, need, timeDP[next.idx][need]));
                    }
                }
            }
        }
    }

    public static void timeDijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (timeDP[now.idx][now.cost] < now.time) {
                continue;
            }

            if (now.idx == N) {
                minTime = Math.min(minTime, now.time);
                continue;
            }

            for (Node next : edges[now.idx]) {
                int costSum = now.cost+next.cost;
                if (costSum <= M) {
                    if (timeDP[next.idx][costSum] > timeDP[now.idx][now.cost] + next.time) {
                        timeDP[next.idx][costSum] = timeDP[now.idx][now.cost] + next.time;
                        pq.offer(new Node(next.idx, costSum, timeDP[next.idx][costSum]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            timeDP = new int[N + 1][M + 1];
            edges = new LinkedList[N + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(timeDP[i], INF);
                edges[i] = new LinkedList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                edges[from].add(new Node(to, cost, time));
            }

//            Arrays.fill(timeDP[1], 0);
            timeDP[1][0]=0;
            minTime = INF;
            timeDijkstra(1);

            if (minTime == INF) {
                answer.append("Poor KCM\n");
            } else {
                answer.append(minTime).append('\n');
            }
        }
        System.out.print(answer.toString().strip());
    }
}
