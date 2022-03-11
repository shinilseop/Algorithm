package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex06_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[size];
        int[] rightBig = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (arr[stack.peek()] > arr[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                        int idx = stack.pop();
                        rightBig[idx] = arr[i];
                    }
                    stack.push(i);
                }
            }
        }


        while (!stack.isEmpty()) {
            int idx = stack.pop();
            rightBig[idx] = -1;
        }

        StringBuffer answer = new StringBuffer();
        answer.append(rightBig[0]);
        for (int i = 1; i < rightBig.length;i++) {
            answer.append(' ').append(rightBig[i]);
        }

        System.out.print(answer.toString());
    }
}
