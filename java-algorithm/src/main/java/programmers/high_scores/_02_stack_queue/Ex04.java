package programmers.high_scores._02_stack_queue;

import java.util.ArrayList;
import java.util.Stack;

public class Ex04 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                System.out.println("INSERT " + i);
            } else {
                if (prices[stack.peek()] <= prices[i]) {
                    stack.push(i);
                    System.out.println("INSERT " + i);
                } else {
                    while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                        int idx = stack.pop();
                        answer[idx] = i - idx;
                        System.out.println("POP "+idx+", "+(i - idx));
                    }
                    stack.push(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
            System.out.println("POP "+idx+", "+(prices.length-1-idx));
        }

        return answer;
    }

    public static int[] arrayslistToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
