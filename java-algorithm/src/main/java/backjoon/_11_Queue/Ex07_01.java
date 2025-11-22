package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex07_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(loop * 30);

        while (loop-- > 0) {
            char[] cmd = (br.readLine()).toCharArray();
            int size = Integer.parseInt(br.readLine());
//            String arr = br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
//                numbers[i] = arr.charAt(i * 2 + 1) - '0';
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            int front = 0, back = size;
            boolean isFront = true;
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == 'R') {
                    isFront = !isFront;
                } else if (cmd[i] == 'D') {
                    if (isFront) {
                        front++;
                    } else {
                        back--;
                    }
                }
            }

            if (front > back) {
                sb.append("error\n");
            } else if(front==back) {
                sb.append("[]\n");
            } else {
                if (isFront) {
                    sb.append('[');
                    for (int i = front; i < back-1; i++) {
                        sb.append(numbers[i]).append(',');
                    }
                    sb.append(numbers[back-1]).append(']').append('\n');
                } else {
                    sb.append('[');
                    for (int i = back-1; i > front; i--) {
                        sb.append(numbers[i]).append(',');
                    }
                    sb.append(numbers[front]).append(']').append('\n');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
