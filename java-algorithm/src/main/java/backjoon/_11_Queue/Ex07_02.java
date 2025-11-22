package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex07_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 30);

        loop:
        while (loop-- > 0) {
            Deque<Integer> deque = new ArrayDeque<>();
            char[] cmd = (br.readLine()).toCharArray();
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < size; i++) {
//                deque.add(arr.charAt(i * 2 + 1) - '0');
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isFront = true;
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == 'R') {
                    isFront = !isFront;
                } else if (cmd[i] == 'D') {
                    if (isFront) {
                        if (deque.pollFirst() == null) {
                            sb.append("error\n");
                            continue loop;
                        }
                    } else {
                        if (deque.pollLast() == null) {
                            sb.append("error\n");
                            continue loop;
                        }
                    }
                }
            }

            sb.append('[');
            if(!deque.isEmpty()){
                if (isFront) {
                    while (deque.size() > 1) {
                        sb.append(deque.pollFirst()).append(',');
                    }
                    sb.append(deque.poll());
                } else {
                    while (deque.size() > 1) {
                        sb.append(deque.pollLast()).append(',');
                    }
                    sb.append(deque.poll());
                }
            }
            sb.append(']').append('\n');
        }
        System.out.print(sb.toString().strip());
    }
}
