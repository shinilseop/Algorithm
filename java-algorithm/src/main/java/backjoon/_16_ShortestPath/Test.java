package backjoon._16_ShortestPath;

import java.io.*;
import java.util.*;

public class Test {
    static int[] dist;
    static boolean[] visited;
    static int N, M, maxMinus;
    static LinkedList<Node>[] edges;

    public static class Node implements Comparable<Node> {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
//            System.out.println("start "+n.idx);

            if (dist[n.idx] == Integer.MIN_VALUE) {
                for (Node next : edges[n.idx]) {
                    if (dist[next.idx] != Integer.MIN_VALUE) {
                        dist[next.idx] = Integer.MIN_VALUE;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            } else {
                for (Node next : edges[n.idx]) {
//                    System.out.println(dist[next.idx] +">"+ (dist[n.idx] + next.weight));
                    if (dist[next.idx] > dist[n.idx] + next.weight) {
                        if(dist[n.idx] + next.weight < maxMinus){
                            dist[next.idx] = Integer.MIN_VALUE;
                        } else {
                            dist[next.idx] = dist[n.idx] + next.weight;
                        }
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }

        }
    }

    public static boolean bellmanFord(int start) {
        dist[start] = 0;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                for(Node node:edges[i]){
                    if(dist[i] != Integer.MAX_VALUE && dist[node.idx] > dist[i] + node.weight){
                        dist[node.idx] = dist[i] + node.weight;
                        if(i==N){
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        edges = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (weight < 0) {
                maxMinus += weight;
            }
            edges[from].add(new Node(to, weight));
        }

        if(!bellmanFord(1)){
            System.out.println(-1);
        } else {
            StringBuffer sb=new StringBuffer();
            for(int i=2;i<=N;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
            System.out.print(sb.toString().strip());
        }
    }
}