package backjoon._11_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Ex07_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            String cmd = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            int[] arr;
            if (input.length()==2) {
                arr = new int[0];
            } else {
                arr = Stream.of(input.substring(1, input.length() - 1).split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
            }

            int front = 0, back = arr.length-1;
            boolean isFront = true, isError = false;
            for (int i = 0; i < cmd.length(); i++) {
                if (cmd.charAt(i) == 'R') {
                    isFront=!isFront;
                } else {
                    if (front > back) {
                        isError = true;
                        break;
                    }

                    if (isFront) {
                        front++;
                    } else {
                        back--;
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
                continue;
            }

            sb.append('[');
            if (front <= back) {
                if (isFront) {
                    sb.append(arr[front]);
                    for (int i = front+1; i <= back; i++) {
                        sb.append(',').append(arr[i]);
                    }
                } else {
                    sb.append(arr[back]);
                    for (int i = back-1; i >= front; i--) {
                        sb.append(',').append(arr[i]);
                    }
                }
            }
            sb.append(']').append('\n');
        }

        System.out.println(sb.toString().strip());
    }
}
