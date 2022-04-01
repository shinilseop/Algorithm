package programmers.another;

import java.util.Stack;

public class Test {
    class Node {
        Node prev;
        Node next;
        boolean removed;
    }

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        Stack<Node> sta = new Stack<>();
        Node[] node = new Node[n];

        for (int i = 0; i < n; i++) {
            node[i] = new Node();
        }

        for (int i = 0; i < n - 1; i++) {
            node[i + 1].prev = node[i];
            node[i].next = node[i + 1];
        }

        Node cur = node[k];

        for (String str : cmd) {
            char command = str.charAt(0);

            if (command == 'U') {
                int dis = Integer.parseInt(str.substring(2));

                for (int i = 0; i < dis; i++) {
                    cur = cur.prev;
                }
            } else if (command == 'D') {
                int dis = Integer.parseInt(str.substring(2));

                for (int i = 0; i < dis; i++) {
                    cur = cur.next;
                }
            } else if (command == 'C') {
                sta.push(cur);
                cur.removed = true;
                Node up = cur.prev;
                Node down = cur.next;

                if (up != null) {
                    up.next = down;
                }

                if (down != null) {
                    down.prev = up;
                    cur = down;
                } else {
                    cur = up;
                }
            } else { // command == 'Z'
                Node reNode = sta.pop();
                reNode.removed = false;
                Node up = reNode.prev;
                Node down = reNode.next;

                if (up != null) {
                    up.next = reNode;
                }

                if (down != null) {
                    down.prev = reNode;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (node[i].removed) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        int n = 8;
        int k = 2;
        String[] cmd = {""};
    }
}
