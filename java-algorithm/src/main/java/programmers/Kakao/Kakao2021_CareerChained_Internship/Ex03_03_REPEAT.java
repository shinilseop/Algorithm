package programmers.Kakao.Kakao2021_CareerChained_Internship;

import java.util.Stack;

public class Ex03_03_REPEAT {
    Node cur, head;

    public class Node {
        Node before, next;
        int idx;
        boolean isDelete;

        public Node(int idx) {
            this.idx = idx;
        }
    }

    public void recovery(Node node) {
        Node newCur = head;
        node.before = null;
        node.next = null;
        node.isDelete = false;

        while (true) {
            if (newCur.idx > node.idx) {
                if (newCur.before == null) {
                    newCur.before = node;
                    node.next = newCur;
                    head = node;
                    break;
                }

                newCur.before.next = node;
                node.before = newCur.before;
                newCur.before = node;
                node.next = newCur;
                break;
            }
            if (newCur.next == null) {
                newCur.next = node;
                node.before = newCur;
                break;
            }

            newCur = newCur.next;
        }
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
        head = nodes[0];
        for (int i = 0; i < cmd.length; i++) {
            String[] cmds = cmd[i].split(" ");
            if (cmds[0].equals("U")) {
                int cnt = Integer.parseInt(cmds[1]);
                for (int j = 0; j < cnt; j++) cur = cur.before;
            } else if (cmds[0].equals("D")) {
                int cnt = Integer.parseInt(cmds[1]);
                for (int j = 0; j < cnt; j++) cur = cur.next;
            } else if (cmds[0].equals("C")) {
                cur.isDelete = true;
                deleted.push(cur);

                if (cur.before != null) {
                    cur.before.next = cur.next;
                }

                if (cur.next != null) {
                    cur.next.before = cur.before;
                    cur = cur.next;
                } else {
                    cur = cur.before;
                }
            } else if (cmds[0].equals("Z")) {
                Node reNode = deleted.pop();
                reNode.isDelete=false;

                if (reNode.before != null) {
                    reNode.before.next = reNode;
                }

                if (reNode.next != null) {
                    reNode.next.before = reNode;
                }
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
        Ex03_03_REPEAT main = new Ex03_03_REPEAT();
//        System.out.println(main.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(main.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }
}
