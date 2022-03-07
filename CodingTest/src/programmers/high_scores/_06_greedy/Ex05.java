package programmers.high_scores._06_greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex05 {
    static LinkedList<Node>[] edges;
    static int size;

    public static class Link implements Comparable<Link> {
        int from, to, cost;

        public Link(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Link link) {
            return -(this.cost - link.cost);
        }
    }

    public static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static boolean isLinked(Link start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.from, 0));
        int cnt = 1;
        boolean[] visited = new boolean[size];
        visited[start.from] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : edges[now.idx]) {
                if ((now.idx == start.from && next.idx == start.to) || (now.idx == start.to && next.idx == start.from)) {
                    continue;
                }

                if (!visited[next.idx]) {
                    visited[next.idx] = true;
                    q.add(new Node(next.idx, 0));
                    cnt++;
                }
            }
        }

        return cnt == size;
    }

    public static int solution(int n, int[][] costs) {
        size = n;
        edges = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            edges[i] = new LinkedList<>();
        }

        PriorityQueue<Link> pq = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            edges[from].add(new Node(to, cost));
            edges[to].add(new Node(from, cost));
            pq.add(new Link(from, to, cost));
        }

        int cost = 0;
        while (!pq.isEmpty()) {
            Link link = pq.poll();

            if (isLinked(link)) {
                for (int i = 0; i < edges[link.from].size(); i++) {
                    if (link.to == edges[link.from].get(i).idx) {
                        edges[link.from].remove(i);
                        break;
                    }
                }
                for (int i = 0; i < edges[link.to].size(); i++) {
                    if (link.from == edges[link.to].get(i).idx) {
                        edges[link.to].remove(i);
                        break;
                    }
                }
                continue;
            } else {
                cost += link.cost;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}
