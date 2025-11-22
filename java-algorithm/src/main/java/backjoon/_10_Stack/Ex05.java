package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer(size*4);
        int value = 1;
        for (int i = 0; i < size; i++) {
            while (stack.isEmpty() || arr[i] > stack.peek()) {
                stack.push(value++);
                sb.append('+').append('\n');
            }
            if (arr[i] == stack.peek()) {
                stack.pop();
                sb.append('-').append('\n');
            } else if (arr[i] < stack.peek()) {
                stack.clear();
                sb = new StringBuffer("NO");
                break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append('-').append('\n');
            stack.pop();
        }

        System.out.println(sb.toString());
    }
}
