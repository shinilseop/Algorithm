package programmers.Kakao.Kakao2021_CareerChained_Internship;

import java.util.Stack;

public class Ex03_02_runtimeError {
    static Node cur, tail;

    public class Node {
        Node before, next;
        int idx;
        boolean isDelete;

        public Node(int idx) {
            this.idx = idx;
            isDelete = false;
            before = null;
            next = null;
        }
    }

    public void insertNode(Node insert) {
        Node now = new Node(tail.idx);
        now.before = tail.before;
        now.next = tail.next;

        while (insert.before == null) {
            if (now.before == null) {
                insert.next = now;
                now.before = insert;
                break;
            } else if (now.idx < insert.idx) {
                if (now.next == null) {
                    now.next = insert;
                    insert.before = now;
                    tail=insert;
                    break;
                }

                insert.next = now.next;
                now.next.before = insert;
                now.next = insert;
                insert.before = now;
                break;
            }

            now = now.before;
        }

        insert.isDelete = false;
    }

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);

        nodes[0].next = nodes[1];
        for (int i = 1; i < n - 1; i++) {
            nodes[i].before = nodes[i - 1];
            nodes[i].next = nodes[i + 1];
        }
        nodes[n - 1].before = nodes[n - 2];

        Stack<Node> deleted = new Stack<>();
        cur = nodes[k];
        tail = nodes[0];
        for (int i = 0; i < cmd.length; i++) {
            System.out.println(cmd[i]);
            String[] cmds = cmd[i].split(" ");
            if (cmds[0].equals("U")) {
                int cnt = Integer.parseInt(cmds[1]);
                System.out.println(cur.idx);
                for (int j = 0; j < cnt; j++) cur = cur.before;
            } else if (cmds[0].equals("D")) {
                int cnt = Integer.parseInt(cmds[1]);
                for (int j = 0; j < cnt; j++) cur = cur.next;
            } else if (cmds[0].equals("C")) {
                cur.isDelete = true;
                deleted.push(cur);
                if (cur.next == null) {
                    cur = cur.before;
                    cur.next.before = null;
                    cur.next = null;
                    tail = cur;
                } else if (cur.before == null) {
                    cur = cur.next;
                    cur.before.next = null;
                    cur.before = null;
                } else {
                    cur.before.next = cur.next;
                    cur.next.before = cur.before;
                    cur = cur.next;
                }
            } else if (cmds[0].equals("Z")) {
                Node recover = deleted.pop();
                insertNode(recover);
            }
        }


        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isDelete) {
                answer.append('X');
            } else {
                answer.append('O');
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Ex03_02_runtimeError main = new Ex03_02_runtimeError();
        System.out.println(main.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }
}
