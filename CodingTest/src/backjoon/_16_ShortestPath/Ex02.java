package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ex02 {
    static Node[] nodes;
    static int[] dist;
    static boolean[] visited;
    static int size;
    static StringBuffer answer;

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

    public static void dijkstra(int start) {
        dist[start] = 0;

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
        size = Integer.parseInt(st.nextToken());
        answer = new StringBuffer(size * 5);
        nodes = new Node[size + 1];
        dist = new int[size + 1];
        visited = new boolean[size + 1];
        for (int i = 0; i <= size; i++) {
            nodes[i] = new Node(i);
            dist[i] = Integer.MAX_VALUE;
        }
        int edges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].addEdge(to, weight);
        }

        dijkstra(start);
        for (int i = 1; i <= size; i++) {
            answer.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.print(answer);
    }
}
