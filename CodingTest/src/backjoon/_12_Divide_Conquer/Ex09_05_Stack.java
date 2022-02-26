package backjoon._12_Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex09_05_Stack {
    static int size;
    static int[] hist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            size = Integer.parseInt(st.nextToken());
            if (size == 0) {
                break;
            }

            hist = new int[size];
            for (int i = 0; i < size; i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                    long height = hist[stack.pop()];
                    long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                    sum = Math.max(sum, width * height);
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = hist[stack.pop()];
                long width = stack.isEmpty() ? size : size - 1 - stack.peek();
                sum = Math.max(sum, width * height);
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
