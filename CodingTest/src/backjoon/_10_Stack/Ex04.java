package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            char[] sentence = (br.readLine()).toCharArray();
            if (sentence[0] == '.') {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isFinish = false;

            for (int i = 0; i < sentence.length; i++) {
                if(sentence[i] == '(' || sentence[i] == '['){
                    stack.push(sentence[i]);
                } else if (sentence[i] == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        sb.append("no\n");
                        isFinish=true;
                        break;
                    }
                } else if (sentence[i] == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        sb.append("no\n");
                        isFinish=true;
                        break;
                    }
                }
            }

            if (!isFinish) {
                if (stack.isEmpty()) {
                    sb.append("yes\n");
                } else {
                    sb.append("no\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
