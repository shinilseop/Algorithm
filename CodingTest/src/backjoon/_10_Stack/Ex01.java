package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    static int[] stack;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        stack = new int[size];
        idx = 0;
        StringBuffer sb = new StringBuffer(size * 5);
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
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
                case "top":
                    sb.append(myTop()).append('\n');
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void myPush(int num) {
        stack[idx++] = num;
    }

    public static int myPop() {
        if(idx == 0)
            return -1;
        int popNum = stack[idx - 1];
        stack[--idx] = 0;
        return popNum;
    }

    public static int mySize() {
        return idx;
    }

    public static boolean myEmpty() {
        if (idx == 0) {
            return true;
        }

        return false;
    }

    public static int myTop() {
        if (idx == 0) {
            return -1;
        } else {
            return stack[idx - 1];
        }
    }
}
