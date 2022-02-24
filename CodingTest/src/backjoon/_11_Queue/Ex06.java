package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    static int[] deque;
    static int front, back;
    static int move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        deque = new int[n * n + 3];
        front = (n/2) * n + 1;
        back = n * ((n/2)+1);
        for (int i = front, value = 1; i <= back; i++) {
            deque[i] = value++;
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            int frontMove = 0, backMove = 0;
            for (int i = front; i <= back; i++) {
                if (num == deque[i]) {
                    frontMove = i - front;
                }
            }
            for (int i = back; i >= front; i--) {
                if (num == deque[i]) {
                    backMove = back - i + 1;
                }
            }
//            System.out.println("MOVE : "+frontMove+" "+backMove);

            if (frontMove <= backMove) {
                while (frontMove-- > 0) {
                    moveBack();
                    move++;
                }
                poll();
            } else {
                while (backMove-- > 0) {
                    moveFront();
                    move++;
                }
                poll();
            }
        }

        System.out.println(move);
    }

    public static void poll() {
        front++;
    }

    public static void moveFront() {
        deque[--front] = deque[back--];
    }

    public static void moveBack() {
        deque[++back] = deque[front++];
    }
}
