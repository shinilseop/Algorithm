package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ex02 {
    static Node[] nodes;
    static int[] dist;
    static boolean[] visited;
    static int N, E;

    public static class Node {
        int num;
        HashMap<Integer, Integer> next;

        public Node(int num) {
            this.num = num;
            next = new HashMap<>();
        }

        public void addEdge(int idx, int weight) {
            if (next.containsKey(idx)) {
                next.put(idx, Math.min(next.get(idx), weight));
            } else {
                next.put(idx, weight);
            }
        }
    }

    public static void dijkstra(int start, int startDist) {
        dist[start] = startDist;

        while (true) {
            int minIdx = -1, min = Integer.MAX_VALUE;
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i] && min > dist[i]) {
                    minIdx = i;
                    min = dist[i];
                }
            }

            if (minIdx == -1) {
                break;
            }

            visited[minIdx] = true;
            Iterator<Integer> iter = nodes[minIdx].next.keySet().iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                if (dist[key] > dist[minIdx] + nodes[minIdx].next.get(key)) {
                    dist[key] = dist[minIdx] + nodes[minIdx].next.get(key);
                    visited[key] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].addEdge(to, weight);
            nodes[to].addEdge(from, weight);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] stopOver = new int[3];
        stopOver[0] = 1;
        stopOver[1] = Integer.parseInt(st.nextToken());
        stopOver[2] = Integer.parseInt(st.nextToken());


        dist = new int[N + 1];
        int startDist = 0, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < stopOver.length; i++) {
            visited = new boolean[N + 1];
            startDist = dist[stopOver[i]];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(stopOver[i], startDist);
        }
        minDist = Math.min(minDist, dist[N]);

        dist = new int[N + 1];
        int tmp = stopOver[1];
        stopOver[1] = stopOver[2];
        stopOver[2] = tmp;
        for (int i = 0; i < stopOver.length; i++) {
            visited = new boolean[N + 1];
            startDist = dist[stopOver[i]];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(stopOver[i], startDist);
        }
        minDist = Math.min(minDist, dist[N]);

        if (minDist == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.print(minDist);
        }
    }
}
