package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
