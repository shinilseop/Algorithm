package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    static int[] q;
    static int cursor;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        q=new int[loop];
        cursor = 0;
        size = 0;

        StringBuffer sb = new StringBuffer(loop*5);
        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comamnd = st.nextToken();
            switch (comamnd) {
                case "push":
                    myPush(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(myPop()).append('\n');
                    break;
                case "size":
                    sb.append(mySize()).append('\n');
                    break;
                case "empty":
                    sb.append(myEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(myFront()).append('\n');
                    break;
                case "back":
                    sb.append(myBack()).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void myPush(int num) {
        q[size++] = num;
    }

    public static int myPop() {
        if (cursor == size) {
            return -1;
        }
        return q[cursor++];
    }

    public static int mySize() {
        return size-cursor;
    }

    public static boolean myEmpty() {
        if(cursor == size)
            return true;
        else
            return false;
    }

    public static int myFront() {
        if (cursor == size) {
            return -1;
        }
        return q[cursor];
    }

    public static int myBack() {
        if (cursor == size) {
            return -1;
        }
        return q[size-1];
    }
}
