package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex06_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (stack.isEmpty() || arr[stack.peek()] >= arr[i]) {
                stack.push(i);
            } else if (arr[stack.peek()] < arr[i]) {
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    arr[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
