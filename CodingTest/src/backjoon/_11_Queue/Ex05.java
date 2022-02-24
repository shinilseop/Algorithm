package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05 {
    static int[] deque;
    static int front, back, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 10);

        deque = new int[loop*2];
        front = back = deque.length/2;
        size = 0;
        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;
                case "size":
                    sb.append(mySize()).append('\n');
                    break;
                case "empty":
                    sb.append(myEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void push_front(int num) {
        if (front == back) {
            back--;
        }
        deque[front++] = num;
        size++;
    }

    public static void push_back(int num) {
        if (front == back) {
            front++;
        }
        deque[back--] = num;
        size++;
    }

    public static int pop_front() {
        if(size == 0)
            return -1;
        size--;
        return deque[--front];
    }

    public static int pop_back() {
        if(size == 0)
            return -1;
        size--;
        return deque[++back];
    }

    public static int mySize() {
        return size;
    }

    public static boolean myEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public static int front() {
        if (size == 0) {
            return -1;
        }
        return deque[front-1];
    }

    public static int back() {
        if (size == 0) {
            return -1;
        }
        return deque[back+1];
    }
}
