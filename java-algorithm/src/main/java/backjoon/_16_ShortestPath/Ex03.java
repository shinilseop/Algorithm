package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03 {
    static int n, m, t;
    static int s, g, h;
    static int[] dist;
    static Node[] nodes;
    static boolean[] visited;

    public static class Node {
        int num;
        boolean pathTarget;
        HashMap<Integer, Integer> edges;

        public Node(int num) {
            this.num = num;
            pathTarget = false;
            edges = new HashMap<>();
        }

        public void addEdge(int idx, int weight) {
            edges.put(idx, weight);
        }
    }

    public static void dijkstra(int start) {
        dist[start] = 0;

        while (true) {
            int minIdx = -1, min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && min > dist[i]) {
                    min = dist[i];
                    minIdx = i;
                }
            }

            if (minIdx == -1) {
                break;
            }

            visited[minIdx] = true;
            Iterator<Integer> iter = nodes[minIdx].edges.keySet().iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                if (dist[key] > dist[minIdx] + nodes[minIdx].edges.get(key)) {
                    visited[key] = false;
                    dist[key] = dist[minIdx] + nodes[minIdx].edges.get(key);
                    nodes[key].pathTarget = nodes[minIdx].pathTarget;

                    if ((minIdx == g && key == h) || (minIdx == h && key == g)) {
                        nodes[key].pathTarget = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(T * 5);

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // node 개수
            m = Integer.parseInt(st.nextToken()); // edge 개수
            t = Integer.parseInt(st.nextToken()); // object 개수

            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken()); // 시작 위치
            g = Integer.parseInt(st.nextToken()); // 지나간 도로 node1
            h = Integer.parseInt(st.nextToken()); // 지나간 도로 node2

            nodes = new Node[n + 1];
            for (int i = 0; i <= n; i++) {
                nodes[i] = new Node(i);
            }

            visited = new boolean[n + 1];
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes[from].addEdge(to, weight);
                nodes[to].addEdge(from, weight);
            }

            int[] obj = new int[t];
            for (int i = 0; i < t; i++) {
                obj[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(obj);

            dijkstra(s);
            for (int i = 0; i < t; i++) {
                if (nodes[obj[i]].pathTarget) {
                    sb.append(obj[i]).append(' ');
                }
            }
            sb.append('\n');
            System.out.println();
            System.out.println(Arrays.toString(dist));
            for (int i = 1; i < nodes.length; i++) {
                System.out.print(nodes[i].pathTarget+" ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.print(sb);
    }
}
