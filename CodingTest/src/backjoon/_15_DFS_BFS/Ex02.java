package backjoon._15_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex02 {
    static boolean visited[];

    public static class Node {
        private int value;
        private ArrayList<Node> next;

        public Node(int value) {
            this.value = value;
            next = new ArrayList<>();
        }

        public void addEdge(Node node) {
            if (!next.contains(node)) {
                next.add(node);
            }
        }

        public boolean equals(Node node) {
            return this.value == node.value;
        }

        public int dfs() {
            int cnt = 0;
            Stack<Node> stack = new Stack<>();
            stack.push(this);
            visited[this.value] = true;

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                cnt++;

                for (int i = node.next.size() - 1; i >= 0; i--) {
                    Node tmp = node.next.get(i);

                    if (!visited[tmp.value]) {
                        visited[tmp.value] = true;
                        stack.push(tmp);
                    }
                }
            }

            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[size+1];
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[start].addEdge(nodes[end]);
            nodes[end].addEdge(nodes[start]);
        }

        visited = new boolean[size+1];
        System.out.println(nodes[1].dfs()-1);
    }
}
