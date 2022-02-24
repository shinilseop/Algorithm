package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex06_01_to {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> output = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < size; i++) {
            int num = stack.pop();

            if (!minStack.isEmpty() && num < minStack.peek()) {
                while (!minStack.isEmpty() && num < minStack.peek()) {
                    maxStack.push(minStack.pop());
                }
                output.push(maxStack.peek());
                maxStack.push(num);
            } else if (!maxStack.isEmpty() && num < maxStack.peek()) {
                output.push(maxStack.peek());
                maxStack.push(num);
            } else {
                while (!maxStack.isEmpty() && num >= maxStack.peek()) {
                    minStack.push(maxStack.pop());
                }
                if (maxStack.isEmpty() || maxStack.peek() < num) {
                    output.push(-1);
                    maxStack.push(num);
                } else {
                    output.push(maxStack.peek());
                    maxStack.push(num);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!output.isEmpty()) {
            sb.append(output.pop()).append(' ');
        }
        System.out.println(sb.toString());
    }
}
