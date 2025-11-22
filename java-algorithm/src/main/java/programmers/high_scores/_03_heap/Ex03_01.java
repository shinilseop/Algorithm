package programmers.high_scores._03_heap;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03_01 {

    public static class Node {
        int num;
        Node next, before;

        Node(int num) {
            this.num = num;
        }
    }

    public static int[] solution(String[] operations) {
        int len = 0;
        Node head = null, tail = null;
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                if (len >= 1) {
                    Node node = new Node(num);

                    Node cur = tail;
                    if (cur.num > node.num) {
                        node.next = tail;
                        tail.before = node;
                    } else {
                        while (cur != null) {
                            if (cur.num <= node.num) {
                                cur.next.before = node;
                                node.next = cur.next;

                                cur.next = node;
                                node.before = cur;
                                break;
                            }

                            cur = cur.next;
                        }
                    }

                    len++;
                } else {
                    Node node = new Node(num);
                    head = node;
                    tail = node;
                    len++;
                }
            } else {
                if (len > 0) {
                    if (num == 1) {
                        head = head.before;
                        len--;
                    } else {
                        tail = tail.next;
                        len--;
                    }
                }
            }

            printNode(tail);
        }
        int[] answer = new int[2];
        if (len > 0) {
            answer[0] = head.num;
            answer[1] = tail.num;
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }

    public static void printNode(Node tail) {
        Node tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.num);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7","I 5","I -5","D -1"})));
    }
}
