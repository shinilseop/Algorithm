package backjoon._10_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(size * 5);

        while (size-- > 0) {
            Stack<Character> stack = new Stack<>();
            char[] parenthesis = (br.readLine()).toCharArray();
            boolean isFinish = false;

            for (int i = 0; i < parenthesis.length; i++) {
                if (parenthesis[i] == '(') {
                    stack.push(parenthesis[i]);
                } else if (parenthesis[i] == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        sb.append("NO\n");
                        isFinish=true;
                        break;
                    }
                }
            }
            if(!isFinish){
                if (stack.isEmpty()) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
