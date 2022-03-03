package backjoon._16_ShortestPath;

import java.io.*;
import java.util.*;

public class Ex05 {
    static final Long INF = Long.parseLong("1000000000000");
    static long dist[][];
    static int n, m;
    static HashMap<Integer, Integer>[] edges;

    public static class Node implements Comparable<Node> {
        int value;
        long weight;

        public Node(int value, long weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            if (this.weight < node.weight) {
                return -1;
            } else if (this.weight == node.weight) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int from = node.value;
            Iterator<Integer> iter = edges[from].keySet().iterator();
            while (iter.hasNext()) {
                int to = iter.next();
                int weight = edges[from].get(to);

                if (dist[start][to] > dist[start][from] + weight) {
                    dist[start][to] = dist[start][from] + weight;
                    pq.add(new Node(to, dist[start][to]));
                }
            }
        }
    }

    public static void floydWarshall() {
        // 기준이 되는 거쳐가는 노드 K
        for (int k = 1; k <= n; k++) {
            // 출발하는 노드 i
            for (int i = 1; i <= n; i++) {
                // 도착하는 노드 j
                for (int j = 1; j <= n; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new HashMap[n + 1];
        dist = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new HashMap<>();
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (edges[a].containsKey(b)) {
                edges[a].put(b, Math.min(edges[a].get(b), c));
            } else {
                edges[a].put(b, c);
            }

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int t = 1; t <= n; t++) {
            System.out.println(Arrays.toString(dist[t]));
        }
        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            dijkstra(i);
//        }
        floydWarshall();

        StringBuffer sb = new StringBuffer(n * n * 2 + n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(dist[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString().strip());
    }
}
