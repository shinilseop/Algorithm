package backjoon._16_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03_pq {
    static int n, m, t;
    static int s, g, h;
    static int[] dist;
    static LinkedList<Node>[] edges;
    static boolean[] visited;

    public static class Node implements Comparable<Node> {
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            visited[n.num] = true;

            for (Node next : edges[n.num]) {
                if (dist[next.num] > dist[n.num] + next.weight) {
                    dist[next.num] = dist[n.num] + next.weight;
                    if(!visited[next.num])
                        pq.add(new Node(next.num, dist[next.num]));
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

            edges = new LinkedList[n + 1];
            dist = new int[n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                edges[i] = new LinkedList<>();
                dist[i] = Integer.MAX_VALUE - 1;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if ((from == g && to == h) || (from == h && to == g)) {
                    weight = weight*2-1;
                } else {
                    weight *= 2;
                }
                edges[from].add(new Node(to, weight));
                edges[to].add(new Node(from, weight));
            }

            int[] obj = new int[t];
            for (int i = 0; i < t; i++) {
                obj[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(obj);

            dijkstra(s);
            for (int i = 0; i < t; i++) {
                if (dist[obj[i]] % 2 == 1) {
                    sb.append(obj[i]).append(' ');
                }
            }
            sb.append('\n');

//            System.out.println(Arrays.toString(dist));
        }
        System.out.print(sb);
    }
}
