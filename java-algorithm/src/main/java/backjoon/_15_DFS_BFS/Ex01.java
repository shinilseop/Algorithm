package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex01 {
    static StringBuffer answer;
    static boolean[] visited;

    public static class Node implements Comparable<Node>{
        int value;
        ArrayList<Node> next;

        public Node(int value) {
            this.value = value;
            next = new ArrayList<>();
        }

        public void addNode(Node node) {
            for (Node tmp : next) {
                if (tmp.equals(node)) {
                    return;
                }
            }

            next.add(node);
        }

        public void dfs() {
            answer.append(value).append(' ');
            for (Node node : next) {
                if (!visited[node.value]) {
                    visited[node.value] = true;
                    node.dfs();
                }
            }
        }

        public void dfsWhile() {
            Stack<Node> stack = new Stack<>();
            stack.push(this);

            while (!stack.isEmpty()) {
                Node node = stack.pop();

                if (!visited[node.value]) {
                    visited[node.value] = true;
                    answer.append(node.value).append(' ');

                    for (int i = node.next.size() - 1; i >= 0; i--) {
                        Node tmp = node.next.get(i);

                        if (!visited[tmp.value]) {
                            stack.push(tmp);
                        }
                    }
                }
            }
        }

        public void bfs(Queue<Node> visit) {
            answer.append(value).append(' ');
            for (Node node : next) {
                if (!visited[node.value]) {
                    visited[node.value] = true;
                    visit.offer(node);
                }
            }

            Node node = null;
            while ((node = visit.poll()) != null) {
                node.bfs(visit);
            }
        }

        public void bfsWhile() {
            Queue<Node> queue = new LinkedList<>();

            queue.add(this);
            visited[this.value] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                answer.append(node.value).append(' ');

                for (Node tmp : node.next) {
                    if (!visited[tmp.value]) {
                        visited[tmp.value] = true;
                        queue.add(tmp);
                    }
                }
            }
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

        public boolean equals(Node node) {
            return this.value==node.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0));
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.get(start).addNode(nodes.get(end));
            nodes.get(end).addNode(nodes.get(start));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(nodes.get(i).next);
//            System.out.print(i+" Next: ");
//            for (Node node : nodes.get(i).next) {
//                System.out.print(node.value+" ");
//            }
//            System.out.println();
        }

        answer = new StringBuffer();
        visited = new boolean[n + 1];
//        nodes.get(v).dfs();
        nodes.get(v).dfsWhile();

        answer.append('\n');
        visited = new boolean[n + 1];
//        nodes.get(v).bfs(new LinkedList<Node>());
        nodes.get(v).bfsWhile();

        System.out.println(answer);
    }
}
